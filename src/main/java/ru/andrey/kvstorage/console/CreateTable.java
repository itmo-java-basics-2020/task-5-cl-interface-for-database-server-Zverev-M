package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTable implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String nameOfDatabase;
    private String nameOfTable;

    public CreateTable(ExecutionEnvironment env_, String nameOfDatabase_, String nameOfTable_) {
        env = env_;
        nameOfDatabase = nameOfDatabase_;
        nameOfTable = nameOfTable_;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> db = env.getDatabase(nameOfDatabase);

        if (db.isEmpty()) {
            return DatabaseCommandResult.error("Database is not found");
        }

        db.get().createTableIfNotExists(nameOfTable);

        return DatabaseCommandResult.success("Success");
    }
}
