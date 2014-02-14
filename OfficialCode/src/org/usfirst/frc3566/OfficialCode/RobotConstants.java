/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc3566.OfficialCode;

/**
 *
 * @author seth
 */
public class RobotConstants {
    // things we need to measure precisely!
    public static final double TIME_TO_FIRE_CATAPULT = 1.0; // seconds;
    public static final double MECANUM_WHEEL_CIRCUMFERENCE = Math.PI * 6.0; // inches (TODO double-check this math!)
    public static final double ENCODER_TICKS_PER_FOOT = 360.0 * (MECANUM_WHEEL_CIRCUMFERENCE / 12.0);
    
    // things we need to calculate carefully! Maybe even _test_!
    public static final double AUTONOMOUS_DISTANCE_TO_DRIVE_AT_HOT_GOAL = 6.0; // feet from start
    public static final double AUTONOMOUS_DISTANCE_TO_DRIVE_AT_COLD_GOAL = 12.0; // feet from start
    public static final double AUTONOMOUS_DISTANCE_TO_FIRE_AT_HOT_GOAL = 5.0; // feet from start
    public static final double AUTONOMOUS_DISTANCE_TO_FIRE_AT_COLD_GOAL = 12.0; // feet from start
    public static final double AUTONOMOUS_SPEED_TO_DRIVE_AT_HOT_GOAL = 1.0; // percentage of full speed
    public static final double AUTONOMOUS_SPEED_TO_DRIVE_AT_COLD_GOAL = 1.0; // percentage of full speed
    public static final double AUTONOMOUS_TIME_TO_WAIT_FOR_COLD_GOAL = 2.0; // seconds
    
    public static final double EL_TORO_RAISE_SPEED = 1.0;
    public static final double EL_TORO_LOWER_SPEED = 1.0;
    public static final double EL_TORO_TIME_FROM_FULL_DOWN_TO_PARK = 0.1; // seconds, FIXME WAG
    public static final double EL_TORO_TIME_FROM_FULL_UP_TO_PARK = 0.1; // seconds, FIXME WAG
    public static final int EL_TORO_FULL_DOWN = 0;
    public static final int EL_TORO_PARK = 1;
    public static final int EL_TORO_FULL_UP = 2;
    public static final double EL_TORO_TWIRL_INWARD_SPEED = 0.5; // percentage of full speed, FIXME WAG
    public static final double EL_TORO_TWIRL_OUTWARD_SPEED = -0.5; // percentage of full speed, FIXME WAG
}
