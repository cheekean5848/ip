package com.duke;

public class DeleteCommand extends Command{

    private final int pos;

    public DeleteCommand(int pos) {
        this.pos = pos;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task ts = tasks.remove(pos-1);
        ui.showMsg("\t Noted, I've removed this task:");
        ui.showMsg("\t  " + ts);
        System.out.println("\t Now you have " + tasks.getCount() + " tasks in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}