package com.nasa.mars.model.ground.impl;

import java.util.ArrayList;
import java.util.List;

import com.nasa.mars.enumerator.Direction;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.ground.Restriction;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;

public class MarsExplorationGroundImpl implements ExplorationGround {

    private List<Restriction> restrictions;

    protected MarsExplorationGroundImpl() {
    }

    public static MarsExplorationGroundImpl getInstance(int x, int y) {
        MarsExplorationGroundImpl ground = new MarsExplorationGroundImpl();
        ground.addRestriction(new GroundLimitRestrictionImpl(Direction.N, y));
        ground.addRestriction(new GroundLimitRestrictionImpl(Direction.E, x));
        ground.addRestriction(new GroundLimitRestrictionImpl(Direction.S, 0));
        ground.addRestriction(new GroundLimitRestrictionImpl(Direction.W, 0));
        return ground;
    }

    @Override
    public void addRestriction(Restriction restriction) {
        if (this.restrictions == null) {
            this.restrictions = new ArrayList<Restriction>();
        }
        this.restrictions.add(restriction);
    }

    @Override
    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    @Override
    public boolean isMoveViolatingRestrictions(Move move, Position position) {
        for (Restriction restriction : this.restrictions) {
            if (restriction.isViolating(move.getCommand(), position)) {
                return true;
            }
        }
        return false;
    }
}
