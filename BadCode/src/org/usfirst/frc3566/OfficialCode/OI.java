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
   /* Old Controller Scheme declarations
    public JoystickButton triggerFire;
    public JoystickButton thumbCreepDrive;
    public Joystick Joystick;
    public JoystickButton rBFullyPickUpBall;
    public JoystickButton lBVomitBall;
    public JoystickButton backResetAutonomous;
    public JoystickButton xTwirlBallIn;
    public JoystickButton bTwirlBallOut;
    public JoystickButton StartCeaseElToro;
    public JoystickButton yRaiseElToro;
    public Joystick xBoxController;
   */
    //New declarations
    public Joystick xBoxDriver;
    public Joystick xBoxAssister;
    public JoystickButton AisShoot;
    public JoystickButton BackisPrepareCatapult;
    public JoystickButton XisSpinToVomit;
    public JoystickButton BisSpinToPickup;
    public JoystickButton LBisRaiseElToro;
    public JoystickButton RBisLowerElToro;
    public JoystickButton YisStopElToro;
    public JoystickButton RightAnalogDownisCreep;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI() {
        /* FORMER CODE: JOYSTICK FOR DRIVER, XBOX FOR ASSISTANT DRIVER
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
        rBFullyPickUpBall.whileHeld(new LoadBall());
        yRaiseElToro=new JoystickButton(xBoxController, 3);
        yRaiseElToro.whenPressed(new RaiseElToro());
        StartCeaseElToro = new JoystickButton(xBoxController, 8);
        StartCeaseElToro.whenPressed(new StopTwirlingElToro());
        */
        
        //NEW CODE: XBOX FOR DRIVER, XBOX FOR ASSISTANT DRIVER
        xBoxDriver= new Joystick(1);
        //On Logitech: A is 2, X is 1, B is 3, Y is 4
        //On Xbox: A is 1, B is 2, X is 3, Y is 4
       
        
    /* AisShoot= new JoystickButton(xBoxDriver,1);
        AisShoot.whenPressed(new FireCatapult());
        BackisPrepareCatapult= new JoystickButton(xBoxDriver,7);
        BackisPrepareCatapult.whenPressed(new PrepareCatapult());
        XisSpinToVomit= new JoystickButton(xBoxDriver,3);
        XisSpinToVomit.whenPressed(new TwirlElToroInward());
        BisSpinToPickup= new JoystickButton(xBoxDriver,2);
        BisSpinToPickup.whenPressed(new TwirlElToroOutward());
        LBisRaiseElToro= new JoystickButton(xBoxDriver,5);
        LBisRaiseElToro.whileHeld(new RaiseElToro());
        RBisLowerElToro= new JoystickButton(xBoxDriver,6);
        RBisLowerElToro.whileHeld(new LowerElToro());
        YisStopElToro= new JoystickButton(xBoxDriver,4);
        YisStopElToro.whenPressed(new StopTwirlingElToro());
        RightAnalogDownisCreep= new JoystickButton(xBoxDriver,10);
        RightAnalogDownisCreep.whileHeld(new CreepDrive());
     */
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Engage Dogbox", new EngageDogbox());
        SmartDashboard.putData("Disengage Dogbox", new DisengageDogbox());
        SmartDashboard.putData("Wind Winch", new WindWinch());
        SmartDashboard.putData("Fire Catapult", new FireCatapult());
        SmartDashboard.putData("Prepare Catapult", new PrepareCatapult());
        SmartDashboard.putData("Lower El Toro", new LowerElToro());
        SmartDashboard.putData("Raise El Toro", new RaiseElToro());
        SmartDashboard.putData("Vomit Ball", new VomitBall());
        SmartDashboard.putData("Stop Twirling El Toro", new StopTwirlingElToro());
        SmartDashboard.putData("Twirl El Toro Inward", new TwirlElToroInward());
        SmartDashboard.putData("Twirl El Toro Outward", new TwirlElToroOutward());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
