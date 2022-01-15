// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Drive;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class TeleopCommand extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Drive m_drive; 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        public NetworkTableEntry driveSpeedEntry;
        private NetworkTableEntry leftInvertedChooser;
        private NetworkTableEntry rightInvertedChooser; 

        private int leftInverted = 1;
        private int rightInverted = 1;

        private NetworkTableEntry deadzoneChooser;

    public TeleopCommand(Drive subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_drive = subsystem;
        addRequirements(m_drive);

        driveSpeedEntry = Shuffleboard.getTab("Teleop").add("Drive Speed", Constants.DriveConstants.driveSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max",1.0,"Min",0.0)).getEntry();

        leftInvertedChooser = Shuffleboard.getTab("Teleop").add("Left Inverted", false).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();
        rightInvertedChooser = Shuffleboard.getTab("Teleop").add("Right Inverted", false).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();


        deadzoneChooser = Shuffleboard.getTab("Teleop").add("Deadzone", Constants.DriveConstants.deadzone).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max",1.0,"Min",0)).getEntry();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double[] sticks = RobotContainer.getInstance().getYAxes();
        if(leftInvertedChooser.getBoolean(false)){
            leftInverted = -1;
        }else{
            leftInverted = 1;
        }
        if(rightInvertedChooser.getBoolean(false)){
            rightInverted = -1;
        }else{
            rightInverted = 1;
        }
        if(Math.abs(sticks[0]) > deadzoneChooser.getDouble(Constants.DriveConstants.deadzone) || Math.abs(sticks[1]) > deadzoneChooser.getDouble(Constants.DriveConstants.deadzone)){
            m_drive.tankDriveRaw(sticks[0]*Math.sqrt(driveSpeedEntry.getDouble(Constants.DriveConstants.driveSpeed))*leftInverted, sticks[1]*Math.sqrt(driveSpeedEntry.getDouble(Constants.DriveConstants.driveSpeed))*rightInverted);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
