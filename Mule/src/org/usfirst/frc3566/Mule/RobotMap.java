// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3566.Mule;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftFrontWheel;
    public static SpeedController driveTrainLeftRearWheel;
    public static SpeedController driveTrainRightFrontWheel;
    public static SpeedController driveTrainRightRearWheel;
    public static RobotDrive driveTrainRobotDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontWheel = new Talon(1, 1);
	LiveWindow.addActuator("DriveTrain", "LeftFrontWheel", (Talon) driveTrainLeftFrontWheel);
        
        driveTrainLeftRearWheel = new Talon(1, 2);
	LiveWindow.addActuator("DriveTrain", "LeftRearWheel", (Talon) driveTrainLeftRearWheel);
        
        driveTrainRightFrontWheel = new Talon(1, 3);
	LiveWindow.addActuator("DriveTrain", "RightFrontWheel", (Talon) driveTrainRightFrontWheel);
        
        driveTrainRightRearWheel = new Talon(1, 4);
	LiveWindow.addActuator("DriveTrain", "RightRearWheel", (Talon) driveTrainRightRearWheel);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeftFrontWheel, driveTrainLeftRearWheel, driveTrainRightFrontWheel, driveTrainRightRearWheel);
	
        driveTrainRobotDrive.setSafetyEnabled(false);
       // driveTrainRobotDrive.setExpiration(1.0);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
