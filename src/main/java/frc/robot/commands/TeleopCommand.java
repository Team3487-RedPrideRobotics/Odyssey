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
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.ClimbConstants;
import frc.robot.subsystems.Climbing;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Lights;
import frc.robot.subsystems.Manipulator;
import frc.robot.util.DPadParser;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class TeleopCommand extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Drive m_drive;
        private final Manipulator manipulator;
        private final Lights lights;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        public NetworkTableEntry driveSpeedEntry;
        private NetworkTableEntry leftInvertedChooser;
        private NetworkTableEntry rightInvertedChooser; 
        private NetworkTableEntry manipulatorSpeedEntry;
        private NetworkTableEntry blowSpeedEntry;
        private NetworkTableEntry suckSpeedEntry;
        private NetworkTableEntry movingHookEntry;
        private NetworkTableEntry elevatedHookEntry;

        private int leftInverted = 1;
        private int rightInverted = 1;

        private NetworkTableEntry deadzoneChooser;
        private Climbing climb;
        private NetworkTableEntry revDeadRedemption;
        private NetworkTableEntry revOuttakeSpeedEntry;
        private NetworkTableEntry deploySpeedEntry;
        private NetworkTableEntry deployDeadzone;
        private NetworkTableEntry slidingHookDeadzone;
        private NetworkTableEntry revIntakeSpeedEntry;
        private NetworkTableEntry elevatedDeadzoneEntry;

    public TeleopCommand(Drive subsystem, Manipulator m_manipulator, Climbing m_climb, Lights m_lights) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_drive = subsystem;
        addRequirements(m_drive);

        driveSpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Drive Speed", Constants.DriveConstants.driveSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max",1.0,"Min",0.0)).getEntry();

        leftInvertedChooser = Shuffleboard.getTab("Teleop").addPersistent("Left Inverted", false).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();
        rightInvertedChooser = Shuffleboard.getTab("Teleop").addPersistent("Right Inverted", false).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();

        deadzoneChooser = Shuffleboard.getTab("Teleop").addPersistent("Deadzone", Constants.DriveConstants.deadzone).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max",1.0,"Min",0)).getEntry();
        slidingHookDeadzone = Shuffleboard.getTab("Teleop").addPersistent("Middle Hook Deadzone", Constants.ClimbConstants.middleHookDeadzone).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max",1.0,"Min",0)).getEntry();

        blowSpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Blow Speed", Constants.ManipulatorConstants.blowSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry();
        suckSpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Suck Speed", Constants.ManipulatorConstants.suckSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry();
        revOuttakeSpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Rev Outtake Speed", Constants.ManipulatorConstants.revOuttakeSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry();
        revIntakeSpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Rev Intake Speed", Constants.ManipulatorConstants.revIntakeSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry(); 
        deploySpeedEntry = Shuffleboard.getTab("Teleop").addPersistent("Deploy Speed", Constants.ManipulatorConstants.deploySpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry();
        elevatedHookEntry = Shuffleboard.getTab("Teleop").addPersistent("Elevated Hook Speed", Constants.ClimbConstants.elevatedHookSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Max", 1.0, "Min", 0.0)).getEntry();
        movingHookEntry = Shuffleboard.getTab("Teleop").addPersistent("Moving Hook Speed", Constants.ClimbConstants.movingHookSpeed).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Min",0.0,"Max",1.0)).getEntry();
        elevatedDeadzoneEntry = Shuffleboard.getTab("Teleop").addPersistent("Elevated Hook Deadzone", Constants.ClimbConstants.elevatedHookDeadzone).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("Min",0.0,"Max",1.0)).getEntry();
        
        
        manipulator = m_manipulator;
        addRequirements(m_manipulator);

        climb = m_climb;
        addRequirements(m_climb);

        lights = m_lights;
        addRequirements(m_lights);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // drive
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
        }else{
            m_drive.tankDriveRaw(0, 0);
        }
        //intake
        //  intake/outtake
        boolean revForward = RobotContainer.getInstance().getIntakeRevForwards();
        boolean revBackward = RobotContainer.getInstance().getIntakeRevBackwards();
        boolean deployIntake = RobotContainer.getInstance().getIntakeDeploy();
        boolean retractIntake = RobotContainer.getInstance().getIntakeRetract();
        double suckInput = RobotContainer.getInstance().getSuck();
        double blowInput = RobotContainer.getInstance().getBlow();

        // rev
        /*
        if(revForward){
            manipulator.inputSetSpeed(-revOuttakeSpeedEntry.getDouble(Constants.ManipulatorConstants.revSpeed));
        }else if(revBackward){
            manipulator.inputSetSpeed(revOuttakeSpeedEntry.getDouble(Constants.ManipulatorConstants.revSpeed));
        }else{
            manipulator.inputSetSpeed(0);
        }
        */

        if(suckInput > blowInput){
            manipulator.inputSetSpeed(suckInput);
            manipulator.revSetSpeed(suckInput);
        }else{
            manipulator.inputSetSpeed(-blowInput);
            manipulator.revSetSpeed(-blowInput);
        }

        

        // deploy/retract
        if(retractIntake){
            manipulator.deploySetSpeed(-deploySpeedEntry.getDouble(Constants.ManipulatorConstants.deploySpeed));
        }else if(deployIntake){
            manipulator.deploySetSpeed(deploySpeedEntry.getDouble(Constants.ManipulatorConstants.deploySpeed));
        }else{
            manipulator.deploySetSpeed(0);
        }

        // climbing
        double middleClimb = RobotContainer.getInstance().getClimbForward();
        // middle hook
        if(Math.abs(middleClimb) > slidingHookDeadzone.getDouble(Constants.ClimbConstants.middleHookDeadzone)){
            climb.setSlidingSpeed(middleClimb * movingHookEntry.getDouble(Constants.ClimbConstants.movingHookSpeed));
        }else{
            climb.setSlidingSpeed(0);
        }

        // left climber
        if(Math.abs(RobotContainer.getInstance().getLeftClimb()) > elevatedDeadzoneEntry.getDouble(Constants.ClimbConstants.elevatedHookDeadzone)){
            climb.setLeftHookSpeed(-RobotContainer.getInstance().getLeftClimb()*elevatedHookEntry.getDouble(Constants.ClimbConstants.elevatedHookSpeed));
        }else{
            climb.setLeftHookSpeed(0);
        }

        // right climber
        if(Math.abs(RobotContainer.getInstance().getRightClimb()) > elevatedDeadzoneEntry.getDouble(Constants.ClimbConstants.elevatedHookDeadzone)){
            climb.setRightHookSpeed(-RobotContainer.getInstance().getRightClimb()*elevatedHookEntry.getDouble(Constants.ClimbConstants.elevatedHookSpeed));
        }else{
            climb.setRightHookSpeed(0);
        }
        
        lights.changeLights(lights.getAlliancePattern());
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
