package com.nasa.mars.model.robot.impl.move;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;

public class TurnRightMoveImpl implements Move {

    public TurnRightMoveImpl() {
    }

    @Override
    public void execute(Position currentPosition, ExplorationGround ground)
            throws RestrictionException {
        currentPosition.rotate(getCommand());
    }

    @Override
    public boolean canMove(ExplorationGround ground,
            Position currentPosition) {
        return true;
    }

    @Override
    public Command getCommand() {
        return Command.TURN_RIGHT;
    }

}
