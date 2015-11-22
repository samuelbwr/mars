package com.nasa.mars.exception;

/**
 * This exception's going to throw when a violation to it happen
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 *
 */
public class RestrictionException extends Throwable {

    private char command;

    public RestrictionException(char command, String message) {
        super(message);
        this.command = command;
    }

    public char getCommand() {
        return command;
    }

    public void setCommand(char command) {
        this.command = command;
    }

}
