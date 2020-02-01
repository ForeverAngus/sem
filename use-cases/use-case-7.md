# USE CASE: 7 Update an employee's details

## CHARACTERISTIC INFORMATION

### Goal in Context

As an HR adviser I want to update an employee's details so that employee's details are kept up-to-date.

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the employee's current employee ID number.  Database contains current employee salary data.

### Success End Condition

Employee's details are successfully updated.

### Failed End Condition

Employee's details remain unchanged.

### Primary Actor

HR Advisor.

### Trigger

A request for Employee detail change is sent to HR.

## MAIN SUCCESS SCENARIO

1. Employee detail change is requested for a given employee.
2. HR advisor captures the current employee details.
3. HR advisor updates one or more employee detail fields.
4. HR advisor receives conformation that the details have been changed.

## EXTENSIONS

1. **Employee ID does not exist**:
    1. HR advisor is informed no such Employee exists.
2. **Employee details remain unchanged**
    1. HR advisor is informed no changes have been made

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0