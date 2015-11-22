package com.nasa.mars.model.robot;

import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.exception.UnexpectedCommandException;

import com.nasa.mars.model.ground.ExplorationGround;

/**
 * The robot that will walk over the exploration ground
 *
 * @author Samuel Berwanger
 * @since 2014-01-08
 *
 */
public interface Robot {

    /**
     * Process the commands that are sent to the robot respecting all the
     * restrictions of the ground
     *
     * @param commands All the commands sent from CASA(ContaAzul Space Agency)
     * @param ground The ground in which the robot will move
     * @return Returns the last robot's position
     *
     * @throws RestrictionException Throws if some restriction is getting broken
     * in the execution
     * @throws UnexpectedCommandException Throws if a invalid command is prompt
     */
    public Position processCommands(String commands,
            ExplorationGround ground) throws UnexpectedCommandException, RestrictionException;

    /**
     * Process a single command that is sent to the robot respecting all the
     * restrictions of the ground
     *
     * @param command All the commands sent from CASA(ContaAzul Space Agency)
     * @param ground The ground in which the robot will move
     * @param currentPosition The current position of the robot
     *
     * @throws RestrictionException Throws if some restriction is getting broken
     * in the execution
     * @throws UnexpectedCommandException Throws if a invalid command is prompt
     */
    public void processCommand(char command, ExplorationGround ground,
            Position currentPosition) throws UnexpectedCommandException, RestrictionException;

}
