package com.nasa.mars.model.ground;

import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;
import java.util.List;

/**
 * Ground in which the robot will move
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 *
 */
public interface ExplorationGround {

    /**
     * Add a restriction to the ground
     *
     * @param restriction The restriction to be added
     */
    public void addRestriction(Restriction restriction);

    /**
     * Get's the restriction from the ground
     *
     * @return The restrictions
     */
    public List<Restriction> getRestrictions();

    /**
     * Verifies if any ground restriction is been violated when executing the
     * move when the robot is on the position
     *
     * @param move The pretended move
     * @param position The current position of the robot
     *
     * @return True if the
     */
    public boolean isMoveViolatingRestrictions(Move move, Position position);
}
