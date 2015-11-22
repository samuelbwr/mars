package robot;

import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.exception.UnexpectedCommandException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.ground.impl.MarsExplorationGroundImpl;
import com.nasa.mars.model.robot.Position;
import com.nasa.mars.model.robot.Robot;
import com.nasa.mars.model.robot.impl.MarsRobotImpl;

/**
 * Tests the robot movements
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 */
public class RobotTest {

    private ExplorationGround ground;
    private Robot robot;

    @Before
    public void prepareEnvironment() {
        robot = new MarsRobotImpl();
        ground = MarsExplorationGroundImpl.getInstance(4, 4);
    }

    @Test
    public void testSimpleAdvanceMove() throws RestrictionException, UnexpectedCommandException {
        Position pos = robot.processCommands("M", ground);
        Assert.assertEquals("[\"0\", \"1\", \"N\"]", pos.toJson());
    }

    @Test
    public void testComplexMove() throws RestrictionException, UnexpectedCommandException {
        Position pos = robot.processCommands("MMRMMRMM", ground);
        Assert.assertEquals("[\"2\", \"0\", \"S\"]", pos.toJson());
    }

    @Test
    public void testTurnLeftMove() throws RestrictionException, UnexpectedCommandException {
        Position position = robot.processCommands("MML", ground);
        Assert.assertEquals("[\"0\", \"2\", \"W\"]", position.toJson());
    }

    @Test
    public void testRepeatTurnLeftMove() throws RestrictionException, UnexpectedCommandException {
        Position position = robot.processCommands("MML", ground);
        Assert.assertEquals("[\"0\", \"2\", \"W\"]", position.toJson());
    }

    @Test
    public void testTurnRightMove() throws RestrictionException, UnexpectedCommandException {
        Position position = robot.processCommands("R", ground);
        Assert.assertEquals("[\"0\", \"0\", \"E\"]", position.toJson());
    }

    @Test(expected = UnexpectedCommandException.class)
    public void testInvalidCommand() throws UnexpectedCommandException, RestrictionException {
        robot.processCommands("A", ground);
    }

    @Test(expected = RestrictionException.class)
    public void testReachingEndOfGround() throws UnexpectedCommandException, RestrictionException {
        robot.processCommands("MMMMMMMMMMMMMMM", ground);

    }
}
