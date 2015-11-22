package com.nasa.mars.enumerator;

public enum Direction {

    N("y"), E("x"), S("y"), W("x");
    private final String axis;

    private Direction(String axis) {
        this.axis = axis;
    }

    public String getAxis() {
        return axis;
    }
}
