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
import org.usfirst.frc3566.OfficialCode.RobotMap;
import org.usfirst.frc3566.OfficialCode.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3566.OfficialCode.RobotConstants;
/**
 *
 */
public class Catapult extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController dogboxEngageMotor = RobotMap.catapultDogboxEngageMotor;
    SpeedController winchMotor = RobotMap.catapultWinchMotor;
    Encoder dogboxEngageEncoder = RobotMap.catapultDogboxEngageEncoder;
    DigitalInput catapultReady = RobotMap.catapultCatapultReady;
    DigitalInput clutchLimit = RobotMap.catapultClutchLimit;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean catapultReady() {
        return catapultReady.get() == RobotConstants.CATAPULT_READY_LIMIT_CLOSED;
    }
    
    public void windWinch() {
        if (!catapultReady()) {
            winchMotor.set(RobotConstants.WINCH_WIND_SPEED);
        }
    }
    
    public void stopWindingWinch() {
        winchMotor.set(0);
    }
    
    public void disengageDogbox() {
        // need to know where the clutch limit switch is and if we have an encoder
    }
    
    public void engageDogbox() {
        // need to know where the clutch limit switch is and if we have an encoder
    }
}
