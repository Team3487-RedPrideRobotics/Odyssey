// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   public static final class DriveConstants{

    public static final int leftMotorPort = 0;
    public static final boolean leftMotorInverted = false;
    public static final boolean rightMotorInverted = false;
    public static final int rightMotorPort = 1;
    public static final int leftEncoder1 = 0;
    public static final int leftEncoder2 = 1;
    public static final boolean leftEncoderInverted = true;
    public static final int rightEncoder1 = 2;
    public static final int rightEncoder2 = 3;
    public static final boolean rightEncoderInverted = true;
    public static final double distancePerPulse = Math.PI*0.5/360; // in feet
    public static final double driveSpeed = 1;
   public static final double deadzone = 0.1;


   }
   public static final class ManipulatorConstants{

      public static final int deployPort = 2;
      public static final int inputPort = 3;
      public static final int deploySpeed = 1;
      public static final double suckSpeed = 0.5;
      public static final double blowSpeed = 1;
      public static final boolean inputInverted = false;
      public static final boolean deployInverted = false;
      public static final int revPort = 4;
    public static final double revDeadzone = 0.1;
    public static final double revOuttakeSpeed = 1;
    public static double revSpeed = 1;
   public static double deployDeadzone = 1;
public static double revIntakeSpeed = 0.5;
   }

   public static final class ClimbConstants{

    public static final int slidingPort = 5;
    public static final int leftLSPort = 4;
    public static final int rightLSPort = 5;
   public static final boolean elevatedHookInverted = false;
	public static final boolean slidingHookInverted = false;
	public static final double elevatedHookSpeed = 1;
public static final double movingHookSpeed = 1;
public static final double middleHookDeadzone = 0.1;
    public static int leftHook= 6;
    public static int rightHook = 7;

   }

public static final int[] deployEncoderPorts = {10,11};
public static final int[] revEncoderPorts = {14,15};
}

