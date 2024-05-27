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

