package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateDatabase implements DatabaseCommand {
    private final ExecutionEnvironment env;
    private final String name;

    public CreateDatabase(ExecutionEnvironment env_, String name_) {
        env = env_;
        name = name_;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        //env.addDatabase(null);
        return DatabaseCommandResult.success("Done");
    }
}
