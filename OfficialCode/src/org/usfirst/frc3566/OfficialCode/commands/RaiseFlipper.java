/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3566.OfficialCode.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3566.OfficialCode.Robot;
import org.usfirst.frc3566.OfficialCode.RobotConstants;
import org.usfirst.frc3566.OfficialCode.RobotMap;
/**
 *
 * @author robotics
 */
public class RaiseFlipper extends Command {
    
    public RaiseFlipper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.flipper);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.flipper.raise();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.flipper.atUpperLimit();
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.flipper.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
