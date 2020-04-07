package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new Solution(result, null, DatabaseCommandStatus.SUCCESS);
    }

    static DatabaseCommandResult error(String message) {
        return new Solution(null, message, DatabaseCommandStatus.FAILED);
    }

    class Solution implements DatabaseCommandResult {
        private String result;
        private String errorMessage;
        private DatabaseCommandStatus status;

        private Solution(String result_, String errorMessage_, DatabaseCommandStatus status_) {
            result = result_;
            errorMessage = errorMessage_;
            status = status_;
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(result);
        }

        @Override
        public boolean isSuccess() {
            return DatabaseCommandStatus.SUCCESS.equals(status);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}