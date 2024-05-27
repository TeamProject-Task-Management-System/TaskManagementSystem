# OOP TEAM PROJECT

## Description

We create a task management console application to keep track of tasks.

First we started with designing the scheme of the project and creating the modules. All the interfaces and implementations for the classes.
Then we created the core of the program. **TaskManagementRepository**, **TaskManagementEngine** and **CommandFactory**.
The next step was to create all the **commands** responsible for running the application.

## Tests

After finishing with the skeleton of the program we created the **unitTests**.

## Models

> Creating the models:
> Board,
> Comment,
> EventLog,
> Identifiable,
> Member,
> Printable,
> Task,
> Team,
> Assignable,
> Bug,
> Story,
> Feedback.

## Core

> TaskManagementRepository,
> TaskManagementEngine,
> CommandFactory.


## Commands

> Hint: When writing parameters you need to add " | " before and after every parameter.

> addingCommands,
> assignOrUnAssignCommands,
> changingCommandsForBug,
> changingCommandsForFeedback,
> changingCommandsForStory,
> contracts,
> creationCommands,
> listingCommands,
> showCommands


## Sample Input

```none
createteam |Team1|
createteam |Team2|
createmember |Member1|
createmember |Member2|
createmember |Member3|
createmember |Member4|
addmembertoteam |Member1|Team1|
addmembertoteam |Member2|Team1|
addmembertoteam |Member3|Team2|
addmembertoteam |Member4|Team2|
createbug |Login Button Unresponsive|Button does not work|High|Minor|
createbug |Page Crash on Submit|Page crashes on action|Low|Major|
createstory |Implement Dark Mode|Support dark theme|Medium|Small|
createstory |Develop Mobile App|Create mobile app|High|Large|
showalltasks
assignbug |1|Member1|
assignbug |2|Member2|
assignstory |3|Member3|
assignstory |4|Member4|
listalltasks
```

## Sample Output

```none
Team with name Team1 crated.
####################
Team with name Team2 crated.
####################
Member with name Member1 created.
####################
Member with name Member2 created.
####################
Member with name Member3 created.
####################
Member with name Member4 created.
####################
Member Member1 has been added to team Team1.
####################
Member Member2 has been added to team Team1.
####################
Member Member3 has been added to team Team2.
####################
Member Member4 has been added to team Team2.
####################
Bug with name Login Button Unresponsive created.
####################
Bug with name Page Crash on Submit created.
####################
Story with name Implement Dark Mode created.
####################
Story with name Develop Mobile App created.
####################
Tasks:
ID: 1 Login Button Unresponsive
ID: 2 Page Crash on Submit
ID: 3 Implement Dark Mode
ID: 4 Develop Mobile App
####################
Bug Login Button Unresponsive assigned to member Member1.
####################
Bug Page Crash on Submit assigned to member Member2.
####################
Story Implement Dark Mode assigned to member Member3.
####################
Story Develop Mobile App assigned to member Member4.
####################
Story ID: 4 Develop Mobile App
Description:
Create mobile app
Assignee: Member4
Size: Large
Priority: High
Status: Not Done
####################
Story ID: 3 Implement Dark Mode
Description:
Support dark theme
Assignee: Member3
Size: Small
Priority: Medium
Status: Not Done
####################
Bug ID: 1 Login Button Unresponsive
Description:
Button does not work
Assignee: Member1
Severity: Minor
Priority: High
Status: Active
####################
Bug ID: 2 Page Crash on Submit
Description:
Page crashes on action
Assignee: Member2
Severity: Major
Priority: Low
Status: Active
####################
```