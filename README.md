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

