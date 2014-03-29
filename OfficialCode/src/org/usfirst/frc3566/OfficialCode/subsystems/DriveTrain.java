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
import java.lang.Math;
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
    Encoder leftRearEncoder = RobotMap.driveTrainLeftRearEncoder;
    Encoder rightFrontEncoder = RobotMap.driveTrainRightFrontEncoder;
    Encoder rightRearEncoder = RobotMap.driveTrainRightRearEncoder;
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
        rightFrontEncoder.reset();
        leftRearEncoder.reset();
        rightRearEncoder.reset();
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
        
        //redefines numbers and sets variables. 
        
        double driveX=oi.xBoxDriver.getRawAxis(1);
        double driveY=oi.xBoxDriver.getRawAxis(2);
        double driveRot=oi.xBoxDriver.getRawAxis(4);
        if(driveX<.15&&driveX>-.15){
            driveX=0;
        }
        if(driveY<.15&&driveY>-.15){
            driveY=0;
        }
        if(driveRot<.25&&driveRot>-.25){
            driveRot=0;
        }
        System.out.println((driveX)+ " " + driveY + " " + driveRot);
        mecanum.mecanumDrive_Cartesian(-1*buffer(driveX)*speedAdjustment,-1*buffer(driveY)*speedAdjustment,(driveRot)*turnAdjustment,0);
      
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
    
    public void cartesian(double xPercentageOfFullSpeed, double yPercentageOfFullSpeed, double rotation, double gyroAngle) {
        mecanum.mecanumDrive_Cartesian(xPercentageOfFullSpeed, yPercentageOfFullSpeed, rotation, gyroAngle);
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
    //Modifiable equation to match proper buffering
    public double buffer(double x){
        if(x<=.125&&x>=-.125){
            x=0;
        }/*else if((x>.125&&x<1)||x<-.125&&x>-1){
            x=(.6619*x*x*x-(.00000000000002*x*x+.3685-.0000000000002*x));
        }else if(x>=1){
            x=1;
        }else if(x<=-1){
            x=-1;
        }*/
        return x;
    }
}
