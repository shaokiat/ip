package main.java.command;

import main.java.*;
import main.java.exceptions.InvalidFileException;
import main.java.exceptions.InvalidInputException;
import main.java.tasks.Task;
import main.java.tasks.TaskList;

public class DeleteCommand extends Command {

    public static final String MESSAGE_SUCCESS = "Noted. I've removed this task:\n";

    public DeleteCommand(String input) {
        super(input);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws InvalidInputException, InvalidFileException {
        if (super.input.length() <= 7) {
            throw new InvalidInputException("☹ OOPS!!! The description of a delete operation cannot be empty / invalid index.");
        }
        int index = Integer.parseInt(super.input.substring(7)) - 1;
        Task taskDeleted = tasks.getTask(index);
        tasks.removeTask(index);
        ui.printMessage(MESSAGE_SUCCESS + taskDeleted);
        storage.save(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
