package com.nasa.mars.model.ground;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.model.robot.Position;

/**
 * This class represent a restriction that will going to be tested and going
 * have to be respected to the robot move
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 */
public interface Restriction {

    /**
     * Verifies if the restriction is going to be violated
     *
     * @param command The command that the user prompt
     * @param currentPosition The current position of the robot.
     * @return Return if the command violated or not the restriction according
     * to the position of the robot
     */
    public boolean isViolating(Command command, Position currentPosition);
}
