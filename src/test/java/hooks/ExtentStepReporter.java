package hooks;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;


public class ExtentStepReporter implements ConcurrentEventListener{
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(
                TestStepFinished.class,
                new EventHandler<TestStepFinished>() {
                    @Override
                    public void receive(TestStepFinished event){
                        if(!(event.getTestStep() instanceof PickleStepTestStep step)) {
                            return;
                        }

                        ExtentTest test = Hooks.getCurrentExtentTest();

                        if(test == null){
                            return;
                        }

                        String stepText = step.getStep().getText();
                        Status status = event.getResult().getStatus();

                        switch (status) {
                            case PASSED:
                                test.pass("STEP [PASSED]: " + stepText);
                                break;

                            case FAILED:
                                test.fail("STEP [FAILED]: " + stepText);
                                break;

                            default:
                                test.warning("STEP [" + status + "]: " + stepText);
                                break;
                        }
                    }
                }
        );
    }
}
