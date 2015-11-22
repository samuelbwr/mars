package com.nasa.mars.exception;

/**
 * This exception's going to throw when a invalid command is prompt
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 *
 */
public class UnexpectedCommandException extends Throwable {

    private char command;

    public UnexpectedCommandException(char command) {
        super();
        this.command = command;
    }

    public char getCommand() {
        return command;
    }

    public void setCommand(char command) {
        this.command = command;
    }

}
