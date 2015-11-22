package com.nasa.mars.model.robot.impl;

import java.util.logging.Logger;

import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.exception.UnexpectedCommandException;
import com.nasa.mars.model.factory.MoveFactory;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;
import com.nasa.mars.model.robot.Robot;

public class MarsRobotImpl implements Robot {

    private static final Logger LOG = Logger.getLogger("MarsRobot");

    public MarsRobotImpl() {
    }

    @Override
    public Position processCommands(String commands,
            ExplorationGround ground) throws RestrictionException, UnexpectedCommandException {

        Position position = Position.getDefaultPosition();

        for (int i = 0; i < commands.length(); i++) {
            processCommand(commands.charAt(i), ground,
                    position);
        }

        return position;
    }

    @Override
    public void processCommand(char command, ExplorationGround ground,
            Position currentPosition) throws RestrictionException, UnexpectedCommandException {

        LOG.fine("Moved to position: " + currentPosition.toJson());

        Move move = MoveFactory.getMoveInstance(command);
        move.execute(currentPosition, ground);

    }
}
