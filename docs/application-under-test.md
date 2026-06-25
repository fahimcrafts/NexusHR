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
- Requires dynamic test data strategy (to be implemented in later phases)

## 5. Automation Strategy Overview

- PIM module will be automated using CRUD-based validation (Create, Read, Update, Delete employee flows)
- Leave module will focus on request submission and approval workflow validation
- Recruitment module will validate job posting to candidate lifecycle flow

## 6. Test Data Isolation Strategy

- All employee records will use timestamp-based unique naming (e.g., John_170000123)
- Where required, UUID-based identifiers will be used for guaranteed uniqueness
- No static test data will be reused across test cases
- Each test is responsible for its own data creation and cleanup when applicable

## 7. Environment Stability Considerations

- UI may change due to shared demo usage
- Tests must avoid hard dependency on dynamic UI data
- Assertions should rely on stable identifiers (IDs, labels, or controlled data)
- Retries may be required for unstable UI responses