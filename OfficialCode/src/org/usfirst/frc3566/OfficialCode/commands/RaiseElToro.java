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
import org.usfirst.frc3566.OfficialCode.RobotMap;
/**
 *
 */
public class  RaiseElToro extends Command {
    public RaiseElToro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.el_Toro);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        if (RobotMap.getElToroCurrentPosition() == RobotConstants.EL_TORO_FULL_DOWN) {
            setTimeout(RobotConstants.EL_TORO_TIME_FROM_FULL_DOWN_TO_PARK);
        }
        if (RobotMap.getElToroCurrentPosition() != RobotConstants.EL_TORO_FULL_UP) {
            RobotMap.el_ToroUpdownMotor.set(RobotConstants.EL_TORO_RAISE_SPEED);
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (RobotMap.getElToroCurrentPosition() == RobotConstants.EL_TORO_FULL_UP) {
            return true;
        } else if(RobotMap.el_ToroUpperCap.get()) {
            RobotMap.setElToroCurrentPosition(RobotConstants.EL_TORO_FULL_UP);
            return true;
        } else if (RobotMap.getElToroCurrentPosition() == RobotConstants.EL_TORO_FULL_DOWN && isTimedOut()) {
            RobotMap.setElToroCurrentPosition(RobotConstants.EL_TORO_PARK);
            return true;
        } else {
            return false;
        }
    }
    // Called once after isFinished returns true
    protected void end() {
        RobotMap.el_ToroUpdownMotor.set(0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
