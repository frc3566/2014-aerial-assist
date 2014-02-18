// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3566.OfficialCode.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3566.OfficialCode.Robot;
import org.usfirst.frc3566.OfficialCode.RobotConstants;
import org.usfirst.frc3566.OfficialCode.RobotMap;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    private NumberArray blobs;
    
    public AutonomousCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

        addParallel(new LowerElToro(RobotConstants.AUTONOMOUS_SPEED_TO_LOWER_EL_TORO));

        /* In RoboRealm, we're sorting our Blobs by Y-coordinate (of their
         * center of gravity). Which means the first blob (BLOBS(0), BLOBS(1))
         * will be the horizontal vision target (lower Y value, closer to the
         * top of the screen) and the second blob (BLOBS(2), BLOBS(3)) (higher
         * Y value, closer to the bottom of the screen) will be the vertical
         * vision target...
         * 
         * BUT, if there is only one blob, then we don't have the horizontal
         * vision target... meaning we're looking at the COLD target.
         */
        blobs = new NumberArray();
        try {
            Robot.roboRealm.retrieveValue("BLOBS", blobs);

            // if we're looking at the hot goal
            if (blobs.size() > 2) {
                hotTarget();

                // ...otherwise, we're looking at the cold goal
            } else {
                coldTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
            /* FIXME once we know that hot/cold differentiation works, let's
             * try failing over to either hot or cold target if we get an
             * exception here!
             */
            // hotTarget();
        }
    }

    private void hotTarget() {
        addParallel(new Drive(RobotConstants.AUTONOMOUS_SPEED_TO_DRIVE_AT_HOT_GOAL, RobotConstants.AUTONOMOUS_DISTANCE_TO_DRIVE_AT_HOT_GOAL));
        addParallel(new FireCatapultAtDistance(RobotConstants.AUTONOMOUS_DISTANCE_TO_FIRE_AT_HOT_GOAL));
    }

    private void coldTarget() {
        addParallel(new Drive(RobotConstants.AUTONOMOUS_SPEED_TO_DRIVE_AT_COLD_GOAL, RobotConstants.AUTONOMOUS_DISTANCE_TO_DRIVE_AT_COLD_GOAL));
        addSequential(new Pause(RobotConstants.AUTONOMOUS_TIME_TO_WAIT_FOR_COLD_GOAL));
        addSequential(new FireCatapult());
    }
}
