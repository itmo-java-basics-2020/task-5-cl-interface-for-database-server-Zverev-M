package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

import java.lang.reflect.Array;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            String[] array = commandText.split(" ");

            if (array.length == 0) {
                throw new IllegalArgumentException("Empty sting");
            }
            if (array.length == 1) {
                throw new IllegalArgumentException("Not enough arguments");
            }

            return DatabaseCommands.valueOf(array[0]).getCommand(env, array).execute();
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }

    }
}
