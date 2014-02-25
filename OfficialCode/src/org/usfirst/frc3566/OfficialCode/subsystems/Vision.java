/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3566.OfficialCode.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;

/**
 *
 * @author robotics
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static NetworkTable roboRealm;

    public Vision() {
        roboRealm = NetworkTable.getTable("RoboRealm");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public int blobCount() {
        int blobCount = 0;
        try {
            blobCount = (int) roboRealm.getNumber("BLOB_COUNT");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blobCount;
    }

    public boolean hotTarget() {
        /* In RoboRealm, we're sorting our Blobs by Y-coordinate (of their
         * center of gravity). Which means the first blob (BLOBS(0), BLOBS(1))
         * will be the horizontal vision target (lower Y value, closer to the
         * top of the screen) and the second blob (BLOBS(2), BLOBS(3)) (higher
         * Y value, closer to the bottom of the screen) will be the vertical
         * vision target...
         * 
         * BUT, if there is only one blob, then we don't have the horizontal
         * vision target... meaning we're looking at the COLD target.
         */
        return blobCount() > 1;
    }
    
    public NumberArray blobCentersOfGravity() {
        NumberArray blobs = new NumberArray();
        try {
            roboRealm.retrieveValue("BLOBS", blobs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blobs;
    }
}
