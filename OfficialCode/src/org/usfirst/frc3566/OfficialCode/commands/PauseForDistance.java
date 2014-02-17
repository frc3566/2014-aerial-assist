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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3566.OfficialCode.Robot;
import org.usfirst.frc3566.OfficialCode.RobotConstants;

/**
 *
 */
public class  PauseForDistance extends Command {

    private double distance = RobotConstants.DRIVETRAIN_DISTANCE_TO_FULL_SPEED;
    private int initialReading;
    
    public PauseForDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    public PauseForDistance(double distanceInFeet) {
        distance = distanceInFeet;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialReading = Robot.driveTrain.getEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (initialReading - Robot.driveTrain.getEncoder()) >= (RobotConstants.ENCODER_TICKS_PER_FOOT * distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
