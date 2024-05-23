package com.company.oop.teamProject.core;

import com.company.oop.teamProject.command.addingCommands.AddMemberToTeamCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignBugCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignStoryCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.UnassignBugCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.UnassignStoryCommand;
import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugPriorityCommand;
import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugSeverityCommand;
import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugStatusCommand;
import com.company.oop.teamProject.command.changingCommandsForFeedback.ChangeFeedbackRatingCommand;
import com.company.oop.teamProject.command.changingCommandsForFeedback.ChangeFeedbackStatusCommand;
import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStoryPriorityCommand;
import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStorySizeCommand;
import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStoryStatusCommand;
import com.company.oop.teamProject.command.contracts.Command;
import com.company.oop.teamProject.command.contracts.enums.CommandType;
import com.company.oop.teamProject.command.creationCommands.*;
import com.company.oop.teamProject.command.listingCommands.ListAllTasksCommand;
import com.company.oop.teamProject.command.listingCommands.ListBugsByAssignee;
import com.company.oop.teamProject.command.listingCommands.ListBugsByStatus;
import com.company.oop.teamProject.command.showCommands.*;
import com.company.oop.teamProject.core.contracts.CommandFactory;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskManagementRepository taskManagementRepository) {
        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString, CommandType.class);

        switch (commandType) {
            case CREATEMEMBER:
                return new CreateMemberCommand(taskManagementRepository);
            case CREATETEAM:
                return new CreateTeamCommand(taskManagementRepository);
            case CREATEBOARD:
                return new CreateBoardCommand(taskManagementRepository);
            case CREATEBUG:
                return new CreateBugCommand(taskManagementRepository);
            case CREATESTORY:
                return new CreateStoryCommand(taskManagementRepository);
            case CREATEFEEDBACK:
                return new CreateFeedbackCommand(taskManagementRepository);
            case CREATECOMMENT:
                return new CreateCommentCommand(taskManagementRepository);
            case ADDMEMBERTOTEAM:
                return new AddMemberToTeamCommand(taskManagementRepository);
            case SHOWALLMEMBERS:
                return new ShowAllMembersCommand(taskManagementRepository);
            case SHOWALLTEAMS:
                return new ShowAllTeamsCommand(taskManagementRepository);
            case SHOWALLBOARDS:
                return new ShowAllBoardsCommand(taskManagementRepository);
            case SHOWALLTEAMMEMBERS:
                return new ShowAllTeamMembersCommand(taskManagementRepository);
            case ASSIGNBUG:
                return new AssignBugCommand(taskManagementRepository);
            case ASSIGNSTORY:
                return new AssignStoryCommand(taskManagementRepository);
            case UNASSIGNBUG:
                return new UnassignBugCommand(taskManagementRepository);
            case UNASSIGNSTORY:
                return new UnassignStoryCommand(taskManagementRepository);
            case CHANGESTORYSIZE:
                return new ChangeStorySizeCommand(taskManagementRepository);
            case CHANGEBUGSTATUS:
                return new ChangeBugStatusCommand(taskManagementRepository);
            case CHANGESTORYSTATUS:
                return new ChangeStoryStatusCommand(taskManagementRepository);
            case CHANGEFEEDBACKSTATUS:
                return new ChangeFeedbackStatusCommand(taskManagementRepository);
            case CHANGEBUGSEVERITY:
                return new ChangeBugSeverityCommand(taskManagementRepository);
            case CHANGEBUGPRIORITY:
                return new ChangeBugPriorityCommand(taskManagementRepository);
            case CHANGEFEEDBACKRATING:
                return new ChangeFeedbackRatingCommand(taskManagementRepository);
            case CHANGESTORYPRIORITY:
                return new ChangeStoryPriorityCommand(taskManagementRepository);
            case SHOWALLTASKS:
                return new ShowAllTasksCommand(taskManagementRepository);
            case LISTALLTASKS:
                return new ListAllTasksCommand(taskManagementRepository);
            case LISTBUGSBYSTATUS:
                return new ListBugsByStatus(taskManagementRepository);
            case LISTBUGSBYASSIGNEE:
                return new ListBugsByAssignee(taskManagementRepository);
            default:
                throw new IllegalArgumentException();
        }
    }
}
