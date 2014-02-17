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
public class  Drive extends Command {
    private double speed = 1.0; // whoa, Nelly!
    private double distance = -1;
    private int initialReading;
    
    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    public Drive(double percentageOfFullSpeed) {
        speed = percentageOfFullSpeed;
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    public Drive(double percentageOfFullSpeed, double distanceInFeet) {
        speed = percentageOfFullSpeed;
        distance = distanceInFeet;
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }    
// Called just before this Command runs the first time
    protected void initialize() {
        initialReading = Robot.driveTrain.getEncoder();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.cartesian(0, speed, 0, 0);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (distance > 0) {
            return (Robot.driveTrain.getEncoder() - initialReading) > (distance * RobotConstants.ENCODER_TICKS_PER_FOOT);
        } else {
            return false;
        }
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
