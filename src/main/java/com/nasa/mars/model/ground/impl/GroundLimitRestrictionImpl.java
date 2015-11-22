package com.nasa.mars.model.ground.impl;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.enumerator.Direction;
import com.nasa.mars.model.ground.Restriction;
import com.nasa.mars.model.robot.Position;

public class GroundLimitRestrictionImpl implements Restriction {

    private final Direction direction;
    private final int limit;

    public GroundLimitRestrictionImpl(Direction direction, int limit) {
        super();
        this.direction = direction;
        this.limit = limit;
    }

    @Override
    public boolean isViolating(Command command, Position currentPosition) {
        if (command.equals(Command.ADVANCE)
                && currentPosition.getDirection().equals(this.direction)) {
            return currentPosition.getAxis(direction.getAxis()) == limit;
        }
        return false;
    }

}
