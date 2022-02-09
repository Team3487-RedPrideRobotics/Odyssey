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

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.*;

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
// Joysticks

  
// commands

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
private final XboxController xInput = new XboxController(0);
private final Joystick climbStick = new Joystick(1);

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
private JoystickButton leftClimbUpButton = new JoystickButton(climbStick, 10);
private JoystickButton leftClimbDownButton = new JoystickButton(climbStick, 9);
private JoystickButton rightClimbDownButton = new JoystickButton(climbStick, 11);
private JoystickButton rightClimbUpButton = new JoystickButton(climbStick, 12);
private JoystickButton deployButton = new JoystickButton(xInput, XboxController.Button.kRightBumper.value);
private JoystickButton retractButton = new JoystickButton(xInput, XboxController.Button.kLeftBumper.value);

    //commands
    private final TeleopCommand m_teleopCommand = new TeleopCommand(m_drive, m_manipulator, m_climb);

  private RobotContainer() {
    configureButtonBindings();
  }


  public double getClimbForward() {
    return climbStick.getY();
  }




  public boolean getLeftClimbUpButton() {
    return leftClimbUpButton.get();
  }




  public boolean getLeftClimbDownButton() {
    return leftClimbDownButton.get();
  }




  public boolean getRightClimbUpButton() {
    return rightClimbUpButton.get();
  }

  public boolean getRightClimbDownButton(){
    return rightClimbDownButton.get();
  }



  public double getSuck() {
    return xInput.getRightTriggerAxis();
  }




  public double getBlow() {
    return xInput.getLeftTriggerAxis();
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


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return new DriveStraightCommand(5d, 0.5, m_drive).andThen(new TurnCommand(m_drive, 90, 0.5)).andThen(new DriveStraightCommand(5d, 0.5, m_drive)).andThen(new TurnCommand(m_drive, 180, 0.5));
  }

  public Command getTeleopCommand(){
    return m_teleopCommand;
  }
  
}

