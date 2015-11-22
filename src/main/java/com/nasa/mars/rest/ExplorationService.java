package com.nasa.mars.rest;

import com.nasa.mars.exception.RestrictionException;
import com.nasa.mars.exception.UnexpectedCommandException;
import com.nasa.mars.model.ground.ExplorationGround;
import com.nasa.mars.model.ground.impl.MarsExplorationGroundImpl;
import com.nasa.mars.model.robot.Robot;
import com.nasa.mars.model.robot.impl.MarsRobotImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Web Service that'll guide the robots on the exploration
 *
 * @author Samuel Berwanger
 * @since 2015-11-21
 */
@Path("/mars")
public class ExplorationService {

    /**
     * This method will process de commands to walk the robot through the
     * exploration field.
     *
     * @param commands Is the coordinates coming from the URL that'll going to guide
     * the robot.
     * @return This returns the path that the robot have passed through.
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{commands}")
    public Response executeCommands(@PathParam("commands") String commands) {
        Robot robot = new MarsRobotImpl();
        ExplorationGround ground = MarsExplorationGroundImpl.getInstance(4, 4);
        try {
            return Response.ok(robot.processCommands(commands, ground).toJson()).build();
        } catch (UnexpectedCommandException uce) {
            uce.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (RestrictionException re) {
            re.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
