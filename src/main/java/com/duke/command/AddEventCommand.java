package com.duke.command;

import com.duke.task.Event;
import com.duke.task.TaskList;
import com.duke.util.Storage;

public class AddEventCommand extends Command {

    private String input;

    public AddEventCommand(String input) {
        this.input = input;
    }

    /**
     * Execute the command to add event task into the list.
     * @param tasks List of Task
     * @param storage Storage used by Duke
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        String des = input.split(" /", 2)[0].split(" ", 2)[1];
        String date = input.split("/", 2)[1].split(" ", 2)[1];
        Event task = new Event(des, date);
        for (int i=0; i<tasks.getCount(); i++) {
            if (tasks.get(i) instanceof Event) {
                Event event = (Event) tasks.get(i);
                if (event.getDescription().equals(task.getDescription()) &&
                        event.getDate().equals(task.getDate())) {
                    return "You already have this task in your task list.";
                }
            }
        }
        tasks.add(task);
        return "Got itm I've added this tasks:\n " + tasks.get(tasks.getCount()-1)
                + "\n Now you have " + tasks.getCount() + " tasks in the list.";
    }
}
