package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class UpdateKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String nameOfDatabase;
    private String nameOfTable;
    private String key;
    private String value;

    public UpdateKey(ExecutionEnvironment env_, String nameOfDatabase_, String nameOfTable_, String key_, String value_) {
        env = env_;
        nameOfDatabase = nameOfDatabase_;
        nameOfTable = nameOfTable_;
        key = key_;
        value = value_;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> db = env.getDatabase(nameOfDatabase);

        if (db.isPresent()) {
            db.get().write(nameOfTable, key, value);
            return DatabaseCommandResult.success("Success");
        }

        return DatabaseCommandResult.error("Database is not found or key is not found");
    }
}
