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
public class  LowerElToro extends Command {
    private double speed = RobotConstants.EL_TORO_LOWER_SPEED;
    
    public LowerElToro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elToro);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    public LowerElToro(double percentageOfFullSpeed){
        this.speed = percentageOfFullSpeed;
        requires(Robot.elToro);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.elToro.lower(speed);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.elToro.monitor();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elToro.atLowerLimit();
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.elToro.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
