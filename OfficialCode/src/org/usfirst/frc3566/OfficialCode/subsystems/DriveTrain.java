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
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3566.OfficialCode.OI;
/**
 *
 */
public class DriveTrain extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.driveTrainLeftFront;
    SpeedController leftRear = RobotMap.driveTrainLeftRear;
    SpeedController rightFront = RobotMap.driveTrainRightFront;
    SpeedController rightRear = RobotMap.driveTrainRightRear;
    RobotDrive mecanum = RobotMap.driveTrainMecanum;
    Encoder leftFrontEncoder = RobotMap.driveTrainLeftFrontEncoder;
    Ultrasonic ultrasonic = RobotMap.driveTrainUltrasonic;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Initialize your subsystem here
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("DriveTrain", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("DriveTrain", "PIDSubsystem Controller", getPIDController());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new MecanumDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return leftFrontEncoder.pidGet();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        leftFront.pidWrite(output);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    public void joystickDrive(OI oi) {
        mecanum.mecanumDrive_Polar(oi.rightJoy.getMagnitude(), oi.rightJoy.getDirectionDegrees(), oi.rightJoy.getZ());
   }
    
    public int getEncoder() {
        return leftFrontEncoder.get();
    }
    
    public void cartesian(double x, double y, double rotation, double gyroAngle) {
        mecanum.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    }
    
    public void stop() {
        mecanum.stopMotor();
    }
}
