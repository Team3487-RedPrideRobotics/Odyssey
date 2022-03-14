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

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AllianceLightsCommand;
import frc.robot.commands.DriveStraightCommand;
import frc.robot.commands.TeleopCommand;
import frc.robot.commands.TrolleyMoveCommand;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Climbing;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Example;
import frc.robot.subsystems.Lights;
import frc.robot.subsystems.Manipulator;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Example m_example = new Example();
    public final Drive m_drive = new Drive();
    public final Manipulator m_manipulator = new Manipulator();
    public final Climbing m_climb = new Climbing();
    public final Lights m_ligts = new Lights();
    public final Camera m_camera = new Camera();;
// Joysticks

  
// commands

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
private final XboxController xInput = new XboxController(0);
private final XboxController climbStick = new XboxController(1);

// control layout:
//  XBOX CONTROLLER:
//    left stick: left tank drive
//    right stick: right tank drive
//  FIGHT STICK:
//    LB/LT: climber forward/backward
//    Y/B: left climber up/down
//    RB/RT: right climber up/down
//  FLIGHT SIM STICK:
//    AXIS 3 (throttle gauge): deploy motor up/down
//    AXIS 1 (forward/backwards): rev forwards/backwards
//    BUTTON 1 (trigger): intake ball
//    BUTTON 2 (side thumb button): shoot ball
//joystick buttons

    //commands
    private final TeleopCommand m_teleopCommand = new TeleopCommand(m_drive, m_manipulator, m_climb, m_ligts);

  private RobotContainer() {
    configureButtonBindings();
  }


  public double getClimbForward() {
    if(climbStick.getRightTriggerAxis() > climbStick.getLeftTriggerAxis()){
      return climbStick.getRightTriggerAxis();
    }
    return -climbStick.getLeftTriggerAxis();
  }




  public double getLeftClimb() {
    return climbStick.getLeftY();
  }

  public double getRightClimb() {
    return climbStick.getRightY();
  }



  public double getSuck() {
    return xInput.getRightTriggerAxis();
  }




  public double getBlow() {
    return xInput.getLeftTriggerAxis();
  }


  public boolean getHoldIntake(){
    return xInput.getXButton();
  }




  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
public double[] getYAxes() {
      double[] sticks = {xInput.getLeftY(),xInput.getRightY()};
      return sticks;
    }

public boolean getIntakeDeploy(){
  return xInput.getYButton();
}

public boolean getIntakeRetract(){
  return xInput.getAButton();
}

public boolean getIntakeRevForwards(){
  return xInput.getLeftBumper();
}

public boolean getIntakeRevBackwards(){
  return xInput.getRightBumper();
}

public boolean getCelelebrationButton(){
  return climbStick.getAButtonPressed();
}

public boolean getShootButton(){
  return xInput.getBButton();
}


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return (new TrolleyMoveCommand(-1, 1, m_climb).andThen(new WaitCommand(1)).andThen(new DriveStraightCommand(-13d, 0.5, m_drive))).raceWith(new AllianceLightsCommand(m_ligts));
  }

  public Command getTeleopCommand(){
    return m_teleopCommand;
  }

  public Command getIdleCommand(){
    return null;
  }
  
}

