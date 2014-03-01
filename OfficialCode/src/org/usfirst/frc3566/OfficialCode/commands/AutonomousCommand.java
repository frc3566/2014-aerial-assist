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

        // if we're looking at the hot goal
        //addSequential(new RaiseElToro(RobotConstants.EL_TORO_RAISE_SPEED));
        if (Robot.vision.hotTarget()) {
            hotTarget();

            // ...otherwise, we're looking at the cold goal
        } else {
            coldTarget();
        }
    }

    private void hotTarget() {
        SmartDashboard.putString("Autonomous","Such Hot wow.");
        addSequential(new Drive(RobotConstants.AUTONOMOUS_SPEED_TO_DRIVE_AT_HOT_GOAL, RobotConstants.AUTONOMOUS_DISTANCE_TO_DRIVE_AT_HOT_GOAL));
        addSequential(new LowerElToro(RobotConstants.AUTONOMOUS_SPEED_TO_LOWER_EL_TORO));
        // addParallel(new FireCatapultAtDistance(RobotConstants.AUTONOMOUS_DISTANCE_TO_FIRE_AT_HOT_GOAL));
        addSequential(new PauseForDistance(RobotConstants.AUTONOMOUS_DISTANCE_TO_FIRE_AT_HOT_GOAL));;
        addSequential(new DisengageDogbox());
        addSequential(new PrepareCatapult());
    }

    private void coldTarget() {
        SmartDashboard.putString("Autonomous","Many cold.");
        addSequential(new Drive(RobotConstants.AUTONOMOUS_SPEED_TO_DRIVE_AT_COLD_GOAL, RobotConstants.AUTONOMOUS_DISTANCE_TO_DRIVE_AT_COLD_GOAL));
        addSequential(new Pause(RobotConstants.AUTONOMOUS_TIME_TO_WAIT_FOR_COLD_GOAL));
        //addSequential(new FireCatapult());
        addSequential(new DisengageDogbox());
        addSequential(new PrepareCatapult());
    }
}
