// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3566.OfficialCode.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc3566.OfficialCode.RobotMap;
import org.usfirst.frc3566.OfficialCode.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3566.OfficialCode.RobotConstants;
/**
 *
 */
public class ElToro extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftArm = RobotMap.elToroLeftArm;
    SpeedController rightArm = RobotMap.elToroRightArm;
    SpeedController elevator = RobotMap.elToroElevator;
    DigitalInput upperLimit = RobotMap.elToroUpperLimit;
    DigitalInput lowerLimit = RobotMap.elToroLowerLimit;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new MonitorElToro());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void raise(double speed) {
        elevator.set(speed);
    }
    
    public void raise() {
        if (!atUpperLimit()) {
            raise(RobotConstants.EL_TORO_RAISE_SPEED);
        }
    }
    
    public void lower(double speed) {
        if (!atLowerLimit()) {
            elevator.set(speed);
        }
    }
    
    public void lower() {
        lower(RobotConstants.EL_TORO_LOWER_SPEED);
    }
    
    public void stop() {
        elevator.set(0);
    }
    
    public boolean atUpperLimit() {
        return upperLimit.get() == RobotConstants.EL_TORO_UPPER_LIMIT_CLOSED;
    }
    
    public boolean atLowerLimit() {
        return lowerLimit.get() == RobotConstants.EL_TORO_LOWER_LIMIT_CLOSED;
    }
    
    public void twirl(double speed) {
        leftArm.set(speed);
        rightArm.set(-speed);
    }
    
    public void twirlInward() {
        twirl(RobotConstants.EL_TORO_TWIRL_INWARD_SPEED);
    }
    
    public void twirlOutward() {
        twirl(RobotConstants.EL_TORO_TWIRL_OUTWARD_SPEED);
    }
    
    public void stopTwirling() {
        twirl(0);
    }
    
    public void monitor() {
        SmartDashboard.putData("El Toro Upper Limit", upperLimit);
        SmartDashboard.putData("El Toro Lower Limit", lowerLimit);
    }
}
