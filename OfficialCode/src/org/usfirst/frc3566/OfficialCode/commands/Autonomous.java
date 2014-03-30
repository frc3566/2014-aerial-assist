// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3566.OfficialCode.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3566.OfficialCode.Robot;
import org.usfirst.frc3566.OfficialCode.RobotConstants;

/**
 * Autonomous code to shoot on the high goal.
 */
public class Autonomous extends CommandGroup {

    private long startTime;

    private final static String START = "Autonomous Started";
    private final static String LOWER = "Autonomous Lower Ball 1";
    private final static String PICKUP = "Autonomous 2nd Ball Pick Up";
    private final static String DRIVE = "Autonomous Drive to Goal";
    private final static String PAUSE = "Autonomous Wait for Hot Goal";
    private final static String BALL1 = "Autonomous Ball 1 Fired";
    private final static String RELOAD = "Autonomous Ball 2 Loaded";
    private final static String BALL2 = "Autonomous Ball 2 Fired";

    private String timestamp() {
        return (System.currentTimeMillis() - startTime) + "ms";
    }

    /**
     * Default autonomous to one ball.
     */
    public Autonomous() {
        this(1);
    }

    /**
     * Autonomous mode with a variable number of balls.
     *
     * With one ball, the robot checks for a hot or cold target, drives forward
     * to firing position and either fires on a hot target or waits for a cold
     * target to become hot and then fires.
     *
     * With two balls, the robot picks up the second ball behind itself, drives
     * forward to firing position and fires both balls in as quick a succession
     * as can be managed.
     *
     * @param numberOfBalls
     */
    public Autonomous(int numberOfBalls) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        startTime = System.currentTimeMillis();

        if (numberOfBalls == 2) {
            twoBallSequence();
        } else {
            if (Robot.vision.hotTarget()) {
                hotTargetSequence();
            } else {
                coldTargetSequence();
            }
            // clear these fields on the dashboard for clarity
            SmartDashboard.putString(PICKUP, "N/A");
            SmartDashboard.putString(RELOAD, "N/A");
            SmartDashboard.putString(BALL2, "N/A");
        }
    }

    /**
     * Pick up the other ball, drive forward and fire both of them. It doesn't
     * matter if the target is hot or cold, since one will go in hot and the
     * other cold, regardless.
     */
    private void twoBallSequence() {
        SmartDashboard.putString(START, "2 Balls @ " + timestamp());
        pickUpSecondBall();
        driveAtGoal();
        fireBothBalls();
    }

    /**
     * Drive the robot forward and fire the ball is fast as possible. Assumes
     * that the catapult may not be fully wound, but fires from however far the
     * catapult _is_ wound.
     *
     * (The concern is that if we finish winding the catapult with the ball on
     * it, the El Toro elbow will knock the ball out of the cradle.)
     */
    private void hotTargetSequence() {
        SmartDashboard.putString(START, "HOT @ " + timestamp());
        dropBall();
        driveAtGoal();
        SmartDashboard.putString(BALL1, timestamp());
        addSequential(new FireCatapult());
    }

    /**
     * Drive the robot forward, wait a beat, then fire the ball. Assumes that
     * the catapult may not be fully wound, but fires from however far the
     * catapult _is_ wound.
     *
     * (The concern is that if we finish winding the catapult with the ball on
     * it, the El Toro elbow will knock the ball out of the cradle.)
     */
    private void coldTargetSequence() {
        SmartDashboard.putString(START, "COLD @ " + timestamp());
        dropBall();
        driveAtGoal();
        SmartDashboard.putString(PAUSE, timestamp());
        addSequential(new Pause(RobotConstants.AUTONOMOUS_WAIT_FOR_COLD_GOAL_TO_BECOME_HOT));
        SmartDashboard.putString(BALL1, timestamp());
        addSequential(new FireCatapult());
    }
    
    /**
     * Lower balanced ball into the catapult/El Toro "cage" for transport.
     */
    private void dropBall() {
        SmartDashboard.putString(LOWER, timestamp());
        addSequential(new LowerElToro(RobotConstants.AUTONOMOUS_EL_TORO_LOWER_SPEED_FOR_BALL_DROP, RobotConstants.AUTONOMOUS_EL_TORO_LOWER_TIME_FOR_BALL_DROP));
        addSequential(new Pause(RobotConstants.AUTONOMOUS_TIME_TO_WAIT_FOR_BALL_TO_DROP));
        addSequential(new RaiseElToro(RobotConstants.AUTONOMOUS_EL_TORO_RAISE_SPEED_FOR_BALL_DROP, RobotConstants.AUTONOMOUS_EL_TORO_RAISE_TIME_FOR_BALL_DROP));
    }

    /**
     * Pick up the second ball, positioned behind the bot.
     */
    private void pickUpSecondBall() {
        SmartDashboard.putString(PICKUP, timestamp());
        addSequential(new TwirlElToroOutward());
        addSequential(new LowerElToro(RobotConstants.AUTONOMOUS_EL_TORO_LOWER_SPEED_FOR_PICK_UP, RobotConstants.AUTONOMOUS_EL_TORO_LOWER_TIME_FOR_PICK_UP));
        addSequential(new StopTwirlingElToro());
    }

    /**
     * Launch first the loaded ball and then load and launch the second ball in
     * quick succession
     */
    private void fireBothBalls() {
        SmartDashboard.putString(BALL1, timestamp());
        addSequential(new FireCatapult());
        SmartDashboard.putString(RELOAD, timestamp());
        addSequential(new TwirlElToroOutward());
        addSequential(new RaiseElToro());
        addParallel(new StopTwirlingElToro());
        SmartDashboard.putString(BALL2, timestamp());
        addSequential(new FireCatapult());
    }

    /**
     * Drive ahead to the autonomous firing location
     */
    private void driveAtGoal() {
        SmartDashboard.putString(DRIVE, timestamp());
        addSequential(new Drive(RobotConstants.AUTONOMOUS_SPEED_TO_DRIVE_AT_GOAL, RobotConstants.AUTONOMOUS_DISTANCE_TO_DRIVE_AT_GOAL));
    }
}
