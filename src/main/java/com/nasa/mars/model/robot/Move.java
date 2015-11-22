package com.nasa.mars.model.robot;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.model.ground.ExplorationGround;

/**
 * Represents the action of the robot's move
 *
 * @author Samuel Berwanger
 * @since 2014-01-08
 */
public interface Move {

    /**
     * Makes the robot do one step.
     *
     * @param currentPosition The actual state of the robot.
     * @param ground The ground in which the robot will move.
     * @throws RestrictionException It'll be thrown if some restriction is
     * getting broken in the execution
     */
    public abstract void execute(Position currentPosition,
            ExplorationGround ground) throws RestrictionException;

    /**
     * Verify if the robot can advance in the map respecting the border's
     * restrictions.
     *
     * @param currentPosition The current position of the robot
     * @param restrictions The ground restrictions that has to obeyed
     * @return Returns true if can make the move
     */
    public abstract boolean canMove(ExplorationGround ground,
            Position currentPosition);

    /**
     * Gets the command that the move is going to use
     *
     * @return The command
     */
    public Command getCommand();
}
