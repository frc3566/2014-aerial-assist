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

import org.usfirst.frc3566.OfficialCode.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public JoystickButton triggerFire;
    public JoystickButton thumbCreepDrive;
    public Joystick Joystick;
    public JoystickButton rBFullyPickUpBall;
    public JoystickButton lBVomitBall;
    public JoystickButton backResetAutonomous;
    public JoystickButton xTwirlBallIn;
    public JoystickButton bTwirlBallOut;
    public JoystickButton StartCeaseElToro;
    public JoystickButton ySemiPickupBall;
    public Joystick xBoxController;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI() {
        Joystick = new Joystick(1);
        xBoxController = new Joystick(2);

        thumbCreepDrive = new JoystickButton(Joystick, 2);
        thumbCreepDrive.whileHeld(new CreepDrive());
        triggerFire = new JoystickButton(Joystick, 1);
        triggerFire.whenReleased(new FireCatapult());

        bTwirlBallOut = new JoystickButton(xBoxController, 2);
        bTwirlBallOut.whileHeld(new TwirlElToroInward());
        xTwirlBallIn = new JoystickButton(xBoxController, 3);
        xTwirlBallIn.whenPressed(new TwirlElToroOutward());
        backResetAutonomous = new JoystickButton(xBoxController, 7);
        backResetAutonomous.whileHeld(new ResetAutonomous());
        lBVomitBall = new JoystickButton(xBoxController, 5);
        lBVomitBall.whenPressed(new VomitBall());
        rBFullyPickUpBall = new JoystickButton(xBoxController, 6);
        rBFullyPickUpBall.whileHeld(new FullyLoadBall());
        ySemiPickupBall=new JoystickButton(xBoxController, 3);
        ySemiPickupBall.whenPressed(new PickUpBall());
        StartCeaseElToro = new JoystickButton(xBoxController, 8);
        StartCeaseElToro.whenPressed(new StopTwirlingElToro());
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // SmartDashboard Buttons
        SmartDashboard.putData("Reset Autonomous", new ResetAutonomous());
        SmartDashboard.putData("Engage Dogbox", new EngageDogbox());
        SmartDashboard.putData("Disengage Dogbox", new DisengageDogbox());
        SmartDashboard.putData("Wind Winch", new WindWinch());
        SmartDashboard.putData("Fire Catapult", new FireCatapult());
        SmartDashboard.putData("Prepare Catapult", new PrepareCatapult());
        SmartDashboard.putData("Lower El Toro", new LowerElToro());
        SmartDashboard.putData("Joystick El Toro", new JoystickElToro());
        SmartDashboard.putData("Raise El Toro", new RaiseElToro());
        SmartDashboard.putData("Pick Up Ball", new PickUpBall());
        SmartDashboard.putData("Vomit Ball", new VomitBall());
        SmartDashboard.putData("Stop Twirling El Toro", new StopTwirlingElToro());
        SmartDashboard.putData("Twirl El Toro Inward", new TwirlElToroInward());
        SmartDashboard.putData("Twirl El Toro Outward", new TwirlElToroOutward());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
