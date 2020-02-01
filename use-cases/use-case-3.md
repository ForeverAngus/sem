# USE CASE: 3 Produce a Report on the Salary of Employees of a Given Manager's Department

## CHARACTERISTIC INFORMATION

### Goal in Context

As an department manager I want to produce a report on the salary of employees in my department so that I can support financial reporting for my department.

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the Manager's Department.  Database contains current employee salary data.

### Success End Condition

A report is available for Department Manager to provide to finance.

### Failed End Condition

No report is produced.

### Primary Actor

Department Manager.

### Trigger

A request for finance information is sent to Department Manager.

## MAIN SUCCESS SCENARIO

1. Finance request salary information for a given manager's department.
2. Department Manager requests department's salary information using their own employee id.
3. Department Manager extracts current salary information of all employees in their department.
4. Department Manager provides report to finance.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0