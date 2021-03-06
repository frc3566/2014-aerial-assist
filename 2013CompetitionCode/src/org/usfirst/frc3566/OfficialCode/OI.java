// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3566.OfficialCode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc3566.OfficialCode.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton switchToArcade;
    public JoystickButton switchToTank;
    public JoystickButton screwUp;
    public JoystickButton screwDown;
    public JoystickButton joystickButton1;
    public Joystick joystick1;
    public JoystickButton joystickButton2;
    public Joystick joystick2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickButton3;
    public JoystickButton joystickButton4;
    public JoystickButton joystickButton5;
    public JoystickButton joystickButton6;
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        joystick2 = new Joystick(2);
        joystick1 = new Joystick(1);
 
   
       // screwDown = new JoystickButton(joystick1, 2);
        //screwDown.whileHeld(new ShooterDown());
       // screwUp = new JoystickButton(joystick1, 3);
      //  screwUp.whileHeld(new ShooterUP());
        switchToTank = new JoystickButton(joystick1, 8);
        switchToTank.whenPressed(new RunTank());
        switchToArcade = new JoystickButton(joystick1, 9);
        switchToArcade.whenPressed(new RunArcade());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("RunTank", new RunTank());
        SmartDashboard.putData("RunArcade", new RunArcade());
        SmartDashboard.putData("ShooterEnable", new ShooterEnable());
        SmartDashboard.putData("ShooterDisable", new ShooterDisable());
        SmartDashboard.putData("TopDeckMEnable", new TopDeckMEnable());
        SmartDashboard.putData("TopDeckMDisable", new TopDeckMDisable());
        SmartDashboard.putData("BeaterBarEnable", new BeaterBarEnable());
        SmartDashboard.putData("HockClose", new HockClose());
        SmartDashboard.putData("HockOpen", new HockOpen());
        SmartDashboard.putData("FrisbeeLoad", new FrisbeeLoad());
        SmartDashboard.putData("FrisbeeStop", new FrisbeeStop());
        SmartDashboard.putData("Shoot", new Shoot());
        SmartDashboard.putData("ShooterUP", new ShooterUP());
        SmartDashboard.putData("ShooterDown", new ShooterDown());
        SmartDashboard.putData("ShooterUperStop", new ShooterUperStop());
        SmartDashboard.putData("ArmUp", new ArmUp());
        SmartDashboard.putData("AngleDown2", new AngleDown2());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
       
        
        joystickButton1 = new JoystickButton(joystick1, 1);
        joystickButton1.whenPressed(new HockCloseOpen());
        
        joystickButton3 = new JoystickButton(joystick1, 4);
        joystickButton3.whileHeld(new DeckWheelOn());
   
        joystickButton4 = new JoystickButton(joystick1, 3);
        joystickButton4.whileHeld(new ScrewUp());
        joystickButton5 = new JoystickButton(joystick1,2);
        joystickButton5.whileHeld(new ScrewDown());
        
      //  joystickButton5 = new JoystickButton(joystick2,3);
        
           
        joystickButton6 = new JoystickButton(joystick2, 3);
        joystickButton6.whileHeld(new DeckWheelOff());
       // joystickButton5.whileHeld(new DeckWheelOff());
                }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }
    public Joystick getJoystick2() {
        return joystick2;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
