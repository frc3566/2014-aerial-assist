/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3566.OfficialCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3566.OfficialCode.Robot;

/**
 *
 * @author Gone Fishin'
 */
public class ScrewDown2 extends Command {
    
    public ScrewDown2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         Robot.shooter.screwdown(0.8);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
         this.end();
    }
}
