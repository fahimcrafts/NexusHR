# NexusHR - Enterprise HR Automation Framework

NexusHR is a Java-based web UI automation framework built to demonstrate enterprise QA/SDET automation practices against the OrangeHRM demo application.

The framework automates core HR workflows across **PIM, Recruitment, and Leave** using Selenium WebDriver, TestNG, Cucumber/Gherkin, Page Object Model design, dynamic test data, parallel execution, Extent Reports, and Jenkins CI.

> **System Under Test:** OrangeHRM Demo  
> **Application URL:** https://opensource-demo.orangehrmlive.com

## Overview
NexusHR is designed as a maintainable automation framework rather than a collection of standalone Selenium tests.

The framework separates test behavior, page interactions, browser management, configuration, reporting, and execution concerns into dedicated layers. This allows new HR workflows to be added without tightly coupling test logic to Selenium implementation details.

The framework currently covers three core business modules:

- **PIM** — Employee management workflows
- **Recruitment** — Candidate management workflows
- **Leave** — Leave request and workflow validation

## Technology Stack
| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Maven | Build and dependency management |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and lifecycle management |
| Cucumber | BDD and Gherkin-based scenarios |
| Extent Reports | HTML test reporting |
| Log4j2 | Framework logging |
| Jenkins | Continuous integration |
| Git / GitHub | Version control and source management |

## Automated Modules

### PIM
- Add employee
- Validate employee information
- Update employee details

### Recruitment
- Add candidate
- Validate candidate profile
- Update candidate status

### Leave
- Navigate leave workflows
- Submit leave requests
- Validate leave-related UI state

## Framework Architecture

```text
Feature Files (Gherkin)
        ↓
Step Definitions
        ↓
Page Objects
        ↓
BasePage / WebDriver
        ↓
Utilities & Configuration
        ↓
Selenium WebDriver
        ↓
OrangeHRM Application
```

## Test Automation Design

NexusHR follows the **Page Object Model (POM)** to separate test behavior from UI implementation.

### Page Objects
Encapsulate locators and user interactions for each application page.

### Step Definitions
Map Gherkin scenarios to reusable Java methods and coordinate the business workflow.

### Base Layer
Provides shared WebDriver and page-level functionality used throughout the framework.

### Utilities
Handle configuration, dynamic test data generation, and framework logging.

### Execution
Cucumber scenarios are executed through TestNG and Maven, with parallel execution supported through thread-isolated WebDriver instances.

## Browser Configuration

Browser selection is externalized through `src/test/resources/config.properties`.

The framework supports:

- Chrome
- Firefox
- Headless browser execution
- 1920×1080 browser configuration

### Default Configuration

The repository defaults to Chrome:

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com
```

### Runtime Browser Override

The browser can be overridden at execution time using a Maven system property without modifying the configuration file:

```text
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

The configuration resolution follows this order:

```text
Maven -Dbrowser override → ConfigReader → config.properties fallback → DriverFactory
```

This allows the same automation suite to execute against supported browsers without changing test or framework code.

## Running Tests

NexusHR uses Maven Surefire to execute the Cucumber/TestNG suite through the `SuiteRunner` entry point.

### Run the Full Test Suite

```text
mvn test
```

The default configuration executes the suite using Chrome.

### Run with a Specific Browser

```text
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

### Execution Flow

```text
mvn test
        ↓
Maven Surefire
        ↓
SuiteRunner
        ↓
Cucumber Features
        ↓
Step Definitions
        ↓
Page Objects
        ↓
Selenium WebDriver
```

## Test Data Management

NexusHR uses dynamic test data generation to reduce dependency on hardcoded test values.

Test data is generated through the `DataGenerator` utility and includes:

- Unique first names
- Unique last names
- Generated employee IDs
- Unique email addresses

Dynamic data allows employee and candidate workflows to create new records across repeated test executions without relying on previously created application data.

## Reporting and Logging

NexusHR generates execution artifacts to support test analysis and failure investigation.

### Extent Reports

Extent Reports provides an HTML execution report containing:

- Scenario execution status
- Step-level execution results
- Failure screenshots
- Test execution details

The report is generated at:

`target/extent-report.html`

### Logging

Log4j2 provides console-based framework logging during execution.

Logs include timestamps, log levels, logger names, and framework execution messages.

## CI/CD Integration

NexusHR is integrated with Jenkins for automated CI test execution.

The Jenkins pipeline:

1. Checks out the repository.
2. Executes the Maven test suite.
3. Archives the Extent Reports HTML artifact.

### Jenkins Pipeline Flow

```text
GitHub Repository
        ↓
Jenkins Checkout
        ↓
Maven Test Execution
        ↓
Cucumber / TestNG Suite
        ↓
Extent Report
        ↓
Archived Jenkins Artifact
```

The pipeline is defined in `Jenkinsfile`.

The generated Extent Report is archived from `target/extent-report.html`.

## Project Structure

```text
nexushr-automation/
├── Jenkinsfile
├── pom.xml
├── README.md
├── testng.xml
├── docs/
│   └── application-under-test.md
└── src/
    └── test/
        ├── java/
        │   ├── base/
        │   ├── hooks/
        │   ├── pages/
        │   ├── runner/
        │   ├── steps/
        │   └── utils/
        └── resources/
            ├── features/
            ├── config.properties
            └── log4j2.xml
```

### Key Directories

- `base/` — WebDriver and shared page functionality
- `hooks/` — Cucumber lifecycle hooks and reporting integration
- `pages/` — Page Object classes
- `runner/` — Cucumber/TestNG suite entry point
- `steps/` — Cucumber step definitions
- `utils/` — Configuration, test data, and logging utilities
- `features/` — Gherkin feature files
- `resources/` — Framework configuration and logging configuration

## Prerequisites

Before running NexusHR locally, ensure the following are installed and available on the system:

- Java 21
- Maven
- Google Chrome and/or Mozilla Firefox

Verify Java and Maven from the terminal:

```text
java -version
mvn -version
```

Jenkins is required only when executing the project through the CI pipeline.

## Notes

NexusHR is built against the OrangeHRM Demo application for automation framework demonstration and portfolio purposes.

Because the application is a shared demo environment, application data and UI behavior may change independently of the framework.

The framework therefore emphasizes maintainable automation design, reusable page objects, dynamic test data, synchronization, configurable browser execution, reporting, and CI integration.