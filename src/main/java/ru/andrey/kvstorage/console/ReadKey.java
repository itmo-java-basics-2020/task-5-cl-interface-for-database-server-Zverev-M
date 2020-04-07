package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class ReadKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String nameOfDatabase;
    private String nameOfTable;
    private String key;

    public ReadKey(ExecutionEnvironment env_, String nameOfDatabase_, String nameOfTable_, String key_) {
        env = env_;
        nameOfDatabase = nameOfDatabase_;
        nameOfTable = nameOfTable_;
        key = key_;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> db = env.getDatabase(nameOfDatabase);

        if (db.isEmpty()) {
            return DatabaseCommandResult.error("Database is not found");
        }

        return DatabaseCommandResult.success(db.get().read(nameOfTable, key));
    }
}
