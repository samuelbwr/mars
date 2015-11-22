package com.nasa.mars.model.factory;

import com.nasa.mars.enumerator.Command;
import com.nasa.mars.exception.UnexpectedCommandException;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.impl.move.AdvanceMoveImpl;
import com.nasa.mars.model.robot.impl.move.TurnLeftMoveImpl;
import com.nasa.mars.model.robot.impl.move.TurnRightMoveImpl;

/**
 * The class instantiates the right move for the command
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 *
 */
public class MoveFactory {

    public static Move getMoveInstance(char command) throws UnexpectedCommandException {
        Command c;
        try {
            c = Command.get(command);
        } catch (Exception e) {
            throw new UnexpectedCommandException(command);
        }
        switch (c) {
            case TURN_LEFT:
                return new TurnLeftMoveImpl();
            case TURN_RIGHT:
                return new TurnRightMoveImpl();
            case ADVANCE:
                return new AdvanceMoveImpl();
            default:
                return null;
        }
    }
}
