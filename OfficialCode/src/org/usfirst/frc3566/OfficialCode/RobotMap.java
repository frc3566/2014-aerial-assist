// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3566.OfficialCode;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
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
    public static SpeedController driveTrainLeftFront;
    public static SpeedController driveTrainLeftRear;
    public static SpeedController driveTrainRightFront;
    public static SpeedController driveTrainRightRear;
    public static RobotDrive driveTrainMecanum;
    public static Encoder driveTrainLeftFrontEncoder;
    public static Encoder driveTrainLeftRearEncoder;
    public static Encoder driveTrainRightFrontEncoder;
    public static Encoder driveTrainRightRearEncoder;
    public static Ultrasonic driveTrainUltrasonic;
    public static SpeedController el_ToroLeftArm;
    public static SpeedController el_ToroRightArm;
    public static SpeedController el_ToroUpdownMotor;
    public static DigitalInput el_ToroUpperCap;
    public static DigitalInput el_ToroLowerCap;
    public static DigitalInput catapultWindowMotorLimit;
    public static SpeedController catapultMotor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // let's number the El Toro positions from 0-2
    // 0 = all the way down
    // 1 = parked up (within the airspace of the bot)
    // 2 = all the way up
    private static int el_ToroCurrentPosition;
    
    public static int getElToroCurrentPosition() {
        return el_ToroCurrentPosition;
    }
    
    public static void setElToroCurrentPosition(int newPosition) {
        el_ToroCurrentPosition = newPosition;
    }
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFront = new Talon(1, 1);
	LiveWindow.addActuator("DriveTrain", "LeftFront", (Talon) driveTrainLeftFront);
        
        driveTrainLeftRear = new Talon(1, 2);
	LiveWindow.addActuator("DriveTrain", "LeftRear", (Talon) driveTrainLeftRear);
        
        driveTrainRightFront = new Talon(1, 3);
	LiveWindow.addActuator("DriveTrain", "RightFront", (Talon) driveTrainRightFront);
        
        driveTrainRightRear = new Talon(1, 4);
	LiveWindow.addActuator("DriveTrain", "RightRear", (Talon) driveTrainRightRear);
        
        driveTrainMecanum = new RobotDrive(driveTrainLeftFront, driveTrainLeftRear,
              driveTrainRightFront, driveTrainRightRear);
	
        driveTrainMecanum.setSafetyEnabled(true);
        driveTrainMecanum.setExpiration(0.1);
        driveTrainMecanum.setSensitivity(0.5);
        driveTrainMecanum.setMaxOutput(1.0);
        driveTrainMecanum.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainMecanum.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainLeftFrontEncoder = new Encoder(1, 1, 1, 2, false, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "LeftFrontEncoder", driveTrainLeftFrontEncoder);
        driveTrainLeftFrontEncoder.setDistancePerPulse(1.0);
        driveTrainLeftFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainLeftFrontEncoder.start();
        driveTrainLeftRearEncoder = new Encoder(1, 3, 1, 4, false, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "LeftRearEncoder", driveTrainLeftRearEncoder);
        driveTrainLeftRearEncoder.setDistancePerPulse(1.0);
        driveTrainLeftRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainLeftRearEncoder.start();
        driveTrainRightFrontEncoder = new Encoder(1, 5, 1, 6, true, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "RightFrontEncoder", driveTrainRightFrontEncoder);
        driveTrainRightFrontEncoder.setDistancePerPulse(1.0);
        driveTrainRightFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainRightFrontEncoder.start();
        driveTrainRightRearEncoder = new Encoder(1, 7, 1, 8, true, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "RightRearEncoder", driveTrainRightRearEncoder);
        driveTrainRightRearEncoder.setDistancePerPulse(1.0);
        driveTrainRightRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainRightRearEncoder.start();
        driveTrainUltrasonic = new Ultrasonic(1, 11, 1, 12);
	LiveWindow.addSensor("DriveTrain", "Ultrasonic", driveTrainUltrasonic);
        
        el_ToroLeftArm = new Talon(1, 5);
	LiveWindow.addActuator("El_Toro", "LeftArm", (Talon) el_ToroLeftArm);
        
        el_ToroRightArm = new Talon(1, 6);
	LiveWindow.addActuator("El_Toro", "RightArm", (Talon) el_ToroRightArm);
        
        el_ToroUpdownMotor = new Talon(1, 7);
	LiveWindow.addActuator("El_Toro", "UpdownMotor", (Talon) el_ToroUpdownMotor);
        
        el_ToroUpperCap = new DigitalInput(1, 9);
	LiveWindow.addSensor("El_Toro", "UpperCap", el_ToroUpperCap);
        
        el_ToroLowerCap = new DigitalInput(1, 10);
	LiveWindow.addSensor("El_Toro", "LowerCap", el_ToroLowerCap);
        
        catapultWindowMotorLimit = new DigitalInput(1, 13);
	LiveWindow.addSensor("Catapult", "WindowMotorLimit", catapultWindowMotorLimit);
        
        catapultMotor = new Talon(1, 8);
	LiveWindow.addActuator("Catapult", "Motor", (Talon) catapultMotor);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
