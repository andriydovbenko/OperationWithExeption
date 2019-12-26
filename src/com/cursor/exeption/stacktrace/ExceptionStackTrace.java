package com.cursor.exeption.stacktrace;

public class ExceptionStackTrace {
    public void executeThrowFirstException() throws Exception {
        throwFirstException();
    }

    public void throwFirstException() throws Exception {
        throw new Exception("Exception was thrown");
    }

    public void catchAndRethrowException() throws Exception {
        try {
            executeThrowFirstException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("New exception was Rethrown");
        }
    }
}