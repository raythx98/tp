package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.information.Job;

/**
 * Adds a job to the job address book.
 */
public class AddJobCommand extends Command {

    public static final String COMMAND_WORD = "add job";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a job to the job address book. "
            + "Parameters: "
            + PREFIX_JOB_TITLE + "JOB TITLE "
            + PREFIX_COMPANY_NAME + "COMPANY NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_JOB_TITLE + "Cashier "
            + PREFIX_COMPANY_NAME + "Walmart "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "recruitment@walmart.com "
            + PREFIX_ADDRESS + "1, Manhatten Street 2, #01-25 "
            + PREFIX_TAG + "High ";

    public static final String MESSAGE_SUCCESS = "New job added: %1$s";
    public static final String MESSAGE_DUPLICATE_JOB = "This job already exists in the job address book";

    private final Job toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddJobCommand(Job job) {
        requireNonNull(job);
        toAdd = job;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasJob(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_JOB);
        }

        model.addJob(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddJobCommand // instanceof handles nulls
                && toAdd.equals(((AddJobCommand) other).toAdd));
    }
}