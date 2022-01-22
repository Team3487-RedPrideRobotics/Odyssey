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
    public static final boolean leftEncoderInverted = false;
    public static final int rightEncoder1 = 2;
    public static final int rightEncoder2 = 3;
    public static final boolean rightEncoderInverted = false;
    public static final double distancePerPulse = 1; //TODO: find actual distance per pulse
    public static final double driveSpeed = 1;
   public static final double deadzone = 0.2;


   }
   public static final class ManipulatorConstants{

      public static final int deployPort = 2;
      public static final int inputPort = 3;
    public static final int deploySpeed = 1;
    public static final double suckSpeed = 0.5;
   public static final double blowSpeed = 1;
   }

   public static final class ClimbConstants{

    public static final int slidingPort = 5;
    public static final int leftLSPort = 4;
    public static final int rightLSPort = 5;
    public static int elevatedHook = 6;

   }
}

