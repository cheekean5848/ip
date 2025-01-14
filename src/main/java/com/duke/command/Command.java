package com.duke.command;

import com.duke.exception.DukeException;
import com.duke.util.Storage;
import com.duke.task.TaskList;

public abstract class Command {

    public abstract String execute(TaskList tasks, Storage storage) throws DukeException;
}
