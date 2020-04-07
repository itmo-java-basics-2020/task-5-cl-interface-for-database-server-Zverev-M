package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] array) {
            if (array.length == 2) {
                return new CreateDatabase(env, array[1]);
            }

            return null;
        }
    },

    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] array) {
            if (array.length == 3) {
                return new CreateTable(env, array[1], array[2]);
            }

            return null;
        }
    },

    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] array) {
            if (array.length == 5) {
                return new UpdateKey(env, array[1], array[2], array[3], array[4]);
            }

            return null;
        }
    },

    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] array) {
            if (array.length == 4) {
                return new ReadKey(env, array[1], array[2], array[3]);
            }

            return null;
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] array);
}
