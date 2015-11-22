package com.nasa.mars.enumerator;

import com.nasa.mars.exception.UnexpectedCommandException;

public enum Command {

    TURN_RIGHT("R"), TURN_LEFT("L"), ADVANCE("M");
    private final String value;

    private Command(String m) {
        this.value = m;
    }

    public String getValue() {
        return value;
    }

    public static Command get(char string) throws UnexpectedCommandException {
        String command = String.valueOf(string);
        for (Command c : Command.values()) {
            if (c.getValue().equalsIgnoreCase(command)) {
                return c;
            }
        }
        throw new UnexpectedCommandException(string);
    }
}
