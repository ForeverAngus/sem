# USE CASE: 8 Delete an employee details

## CHARACTERISTIC INFORMATION

### Goal in Context

As an HR advisor I want to delete an employee's details so that the company is compliant with data retention legislation. 

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the Employee ID.  Database contains current employee salary data.

### Success End Condition

An Employee's details are successfully removed from the system.

### Failed End Condition

The Employee details remain on the system.

### Primary Actor

HR Advisor.

### Trigger

A request for Employee detail deletion is sent to HR.

## MAIN SUCCESS SCENARIO

1. A request for Employee detail deletion is sent to HR.
2. HR advisor captures the current employee details.
3. HR advisor removes the requested details.
4. HR advisor receives conformation of changes made.

## EXTENSIONS

3. **Employee ID does not exist**:
    1. HR advisor informs employee no such ID exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0