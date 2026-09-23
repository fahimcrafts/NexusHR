# NexusHR - Application Under Test (AUT)

## 1. Application Details
- Name: OrangeHRM Demo (NexusHR System Under Test)
- URL: https://opensource-demo.orangehrmlive.com
- Type: Web-based HR Management System

## 2. Login Validation Result
- Status: PASSED
- Result: Login works consistently across multiple cycles

## 3. Core Modules Identified
- PIM
- Leave
- Recruitment

## 4. Environment Risk
- Shared demo environment
- Data may be modified by other users
- Dynamic test data generation is used to reduce state contamination
- UI behavior may change independently of the framework

## 5. Automation Strategy Overview

- PIM module covers employee creation, information validation, and employee detail updates
- Leave module covers leave navigation, leave request submission, and leave-related UI validation
- Recruitment module covers candidate creation, candidate profile validation, and candidate status updates
- Page Objects isolate UI interactions from business-level test behavior
- Cucumber/Gherkin scenarios are executed through the TestNG/Maven runner

## 6. Test Data Isolation Strategy

- Employee and candidate workflows use dynamically generated test data
- Unique names, employee IDs, and email addresses are generated through the `DataGenerator` utility
- Dynamic values reduce collisions with records created by other users or previous test runs
- Tests avoid relying on fixed application records wherever dynamic data is practical

## 7. Environment Stability Considerations

- The demo application is a shared environment, so application data and UI state may change between executions
- Tests use synchronization and visibility checks to reduce timing-related failures
- Assertions should rely on stable application identifiers, labels, and controlled test data
- Browser configuration and execution behavior are externalized through framework configuration
- Test reports and Log4j2 logging provide evidence for investigating execution failures