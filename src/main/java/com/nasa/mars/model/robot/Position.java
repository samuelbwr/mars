package com.nasa.mars.model.robot;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.enumerator.Direction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Represents a position on the ground in which the robot is or was
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 *
 */
public class Position {

    private static final Logger LOG = Logger.getLogger("Position");

    private static final String AXIS_Y = "y";
    private static final String AXIS_X = "x";

    private Map<String, Integer> axes = new HashMap<String, Integer>();

    private Direction direction;

    public Position(int axisX, int axisY, Direction direction) {

        this.axes.put(AXIS_X, axisX);
        this.axes.put(AXIS_Y, axisY);

        this.direction = direction;
    }

    public static Position getDefaultPosition() {
        return new Position(0, 0, Direction.N);
    }

    public Integer getAxisX() {
        return axes.get(AXIS_X);
    }

    public Integer getAxisY() {
        return axes.get(AXIS_Y);
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getAxis(String axis) {
        return axes.get(axis);
    }

    public void addToAxis(String axis) {
        this.axes.put(axis, this.axes.get(axis) + 1);
    }

    public void subtractFromAxis(String axis) {
        this.axes.put(axis, this.axes.get(axis) - 1);
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void rotate(Command command) {
        setDirection(turn(command));
        LOG.fine("Turned to: " + this.direction);
    }

    public Direction turn(Command comm) {
        List<Direction> directions = Arrays.asList(Direction.values());
        int index = directions.indexOf(this.direction);

        // If it gets to the end of the 4 coordinates, restart
        if (comm == Command.TURN_RIGHT && index == 3) {
            return directions.get(0);
        } else if (comm == Command.TURN_LEFT && index == 0) {
            return directions.get(3);

            // Otherwise just move to the following
        } else {
            return directions.get(comm == Command.TURN_RIGHT ? ++index
                    : --index);
        }
    }

    public String toJson() {
        return "[\"" + getAxisX() + "\", \"" + getAxisY() + "\", \"" + getDirection() + "\"]";
    }

}
