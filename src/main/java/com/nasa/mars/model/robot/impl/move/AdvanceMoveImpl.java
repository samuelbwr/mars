package com.nasa.mars.model.robot.impl.move;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;

public class AdvanceMoveImpl implements Move {

    public AdvanceMoveImpl() {

    }

    @Override
    public void execute(Position currentPosition, ExplorationGround ground)
            throws RestrictionException {

        if (canMove(ground, currentPosition)) {
            switch (currentPosition.getDirection()) {
                case N:
                case E:
                    currentPosition.addToAxis(currentPosition.getDirection()
                            .getAxis());
                    break;
                case W:
                case S:
                    currentPosition.subtractFromAxis(currentPosition
                            .getDirection().getAxis());
                    break;
                default:
                    break;
            }
        } else {
            throw new RestrictionException('M', "Got to the board");
        }

    }

    @Override
    public boolean canMove(ExplorationGround ground,
            Position currentPosition) {
        return !ground.isMoveViolatingRestrictions(this, currentPosition);
    }

    @Override
    public Command getCommand() {
        return Command.ADVANCE;
    }

}
