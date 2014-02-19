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
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3566.OfficialCode.OI;
import org.usfirst.frc3566.OfficialCode.RobotConstants;
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
        leftFrontEncoder.reset();
        mecanum.stopMotor();
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
    
    public void joystickDrive(OI oi, double speedAdjustment, double turnAdjustment) {
      //  mecanum.mecanumDrive_Polar(oi.xBoxDriver.getMagnitude() * speedAdjustment, oi.xBoxDriver.getDirectionDegrees() * turnAdjustment, oi.xBoxDriver.getZ());
      if(Math.abs(oi.xBoxDriver.getRawAxis(1))>.1||Math.abs(oi.xBoxDriver.getRawAxis(2))>.1||Math.abs(oi.xBoxDriver.getRawAxis(4))>.1){
        mecanum.mecanumDrive_Cartesian(-1*oi.xBoxDriver.getRawAxis(1)*speedAdjustment,-1*oi.xBoxDriver.getRawAxis(2)*speedAdjustment,oi.xBoxDriver.getRawAxis(4)*turnAdjustment,0);
        }
    } 
    public void joystickDrive(OI oi)
    {
        joystickDrive(oi, RobotConstants.DRIVETRAIN_NORMAL_SPEED, RobotConstants.DRIVETRAIN_NORMAL_TURN);
    }
    
    public int getTicks() {
        return leftFrontEncoder.get();
    }
    
    public double getDistance() {
        return leftFrontEncoder.getDistance();
    }
    
    public void reset() {
        leftFrontEncoder.reset();
    }
    
    public void cartesian(double x, double y, double rotation, double gyroAngle) {
        mecanum.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    }
    
    public void stop() {
        leftFront.set(0);
        rightFront.set(0);
        leftRear.set(0);
        rightRear.set(0);
        // mecanum.stopMotor();
    }
    
    public void monitor() {
        SmartDashboard.putData("Left Front Encoder", leftFrontEncoder);
    }
}
