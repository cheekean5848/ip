package com.duke.command;

import com.duke.exception.DukeException;
import com.duke.task.Deadline;
import com.duke.task.Task;
import com.duke.task.TaskList;
import com.duke.task.Todo;
import com.duke.util.Storage;

import java.time.format.DateTimeParseException;

public class AddDeadlineCommand extends Command {

    private String input;

    public AddDeadlineCommand(String input) {
        this.input = input;
    }

    /**
     * Execute the command to add deadline task into the list.
     * @param tasks List of Task
     * @param storage Storage used by Duke
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            String des = input.split(" /", 2)[0].split(" ", 2)[1];
            String date = input.split("/", 2)[1].split(" ", 2)[1];
            Deadline task = new Deadline(des, date);
            for (int i=0; i<tasks.getCount(); i++) {
                if (tasks.get(i) instanceof Deadline) {
                    Deadline deadline = (Deadline) tasks.get(i);
                    if (deadline.getDescription().equals(task.getDescription()) &&
                            deadline.getDate().equals(task.getDate())) {
                        return "You already have this task in your task list.";
                    }
                }
            }
            tasks.add(task);
            return "Got itm I've added this tasks:\n " + tasks.get(tasks.getCount()-1)
                    + "\n" + "Now you have " + tasks.getCount() + " tasks in the list.";
        } catch (DateTimeParseException e) {
            throw new DukeException("\t " + "The date format should be YYYY-MM-DD");
        }

    }
}
