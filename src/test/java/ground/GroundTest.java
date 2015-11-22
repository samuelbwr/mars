package ground;

import com.nasa.mars.enumerator.Direction;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.ground.impl.MarsExplorationGroundImpl;
import com.nasa.mars.model.robot.Move;
import com.nasa.mars.model.robot.Position;
import com.nasa.mars.model.robot.impl.move.AdvanceMoveImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ground and it's restrictions
 *
 * @author Samuel Berwanger
 * @since 2015-11-22
 */
public class GroundTest {

    private ExplorationGround ground;
    private Move move;
    private Position position;

    @Before
    public void prepareEnvironment() {
        ground = MarsExplorationGroundImpl.getInstance(4, 4);
    }

    @Test
    public void testViolatingRestrictions() {
        position = new Position(4, 4, Direction.N);
        move = new AdvanceMoveImpl();
        Assert.assertTrue(ground.isMoveViolatingRestrictions(move, position));
    }

}
