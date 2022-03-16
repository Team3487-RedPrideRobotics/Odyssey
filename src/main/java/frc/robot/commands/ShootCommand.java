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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.ManipulatorConstants;
import frc.robot.subsystems.Manipulator;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class ShootCommand extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    private Double m_speed;

    private Double m_angle;

    private Manipulator manipulator;
    private boolean shooting = false;

    private boolean firstPass = true;

    private Timer timer;

    private boolean finished = false;

    private double m_shoot_speed;

    private Timer shoot_time;
    private Integer m_shoot_angle;

    public ShootCommand(Manipulator m_manipulator, Double shoot_speed, Integer shoot_angle) {
        shoot_time = new Timer();
        m_shoot_speed = shoot_speed;
        m_shoot_angle = shoot_angle;
        manipulator = m_manipulator;


    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        manipulator.deployResetEncoder();
        shoot_time.reset();
        shoot_time.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        go_to_shoot();
        shoot_ball();
        if(shoot_time.get() >= ManipulatorConstants.rev_time + 1){
            finished = true;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        manipulator.revSetSpeed(0);
        manipulator.inputSetSpeed(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }

    private void shoot_ball() {
        manipulator.revSetSpeed(m_shoot_speed);
        if(shoot_time.get() >= ManipulatorConstants.rev_time){
            manipulator.inputSetSpeed(1);
        }
    }

    private void go_to_shoot() {
        double deltaDistance = manipulator.deployGetPosition()-m_shoot_angle;
        if(Math.abs(deltaDistance) >= Constants.ManipulatorConstants.threshold){
            manipulator.deploySetSpeed(1 * -1 * Math.signum(deltaDistance) *  Math.abs(deltaDistance/71));
        }else{
            manipulator.deploySetVoltage(ManipulatorConstants.hold_multiplier);
        }
    }
}
