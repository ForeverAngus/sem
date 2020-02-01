# USE CASE: 4 Produce a Report on an Employee's details 

## CHARACTERISTIC INFORMATION

### Goal in Context

As an HR advisor I want to view an employee's details so that the employee's promotion request can be supported.

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the Employee's ID.  Database contains current employee salary data.

### Success End Condition

A report is available for HR to process a promotion request.

### Failed End Condition

No report is produced.

### Primary Actor

HR Advisor.

### Trigger

A request for an employee's promotion is sent to HR.

## MAIN SUCCESS SCENARIO

1. HR adviser receives a request for the promotion of an employee.
2. HR advisor captures details of the employee using an employee ID.

## EXTENSIONS

3. **Employee ID does not exist**:
    1. HR adviser is informed the Employee ID is incorrect.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0