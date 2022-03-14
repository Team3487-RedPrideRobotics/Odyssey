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

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DriveStraightCommand extends CommandBase {
	
	public Drive m_drive;
	
	public boolean finished;
	
	private final Double distance;
	
	private final Double speed;
	
	public DriveStraightCommand(Double distanceInFeet, Double m_speed, Drive drive) {
		
		
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		
		m_drive = drive;
		addRequirements(m_drive);
		
		distance = distanceInFeet;
		speed = m_speed;
		
		finished = false;
		
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
	
	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		m_drive.resetEncoders();
		m_drive.resetGyro();
	}
	
	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		if (distance >= 0) {
			if (m_drive.getEncoderDistance()[0] >= distance /* in feet*/) {
				m_drive.tankDriveRaw(0, 0);
				finished = true;
			}
			else {
				m_drive.tankDriveRaw(Math.sqrt(speed), -Math.sqrt(speed));
			}
		}
		else {
			if (m_drive.getEncoderDistance()[0] <= distance /* in feet*/) {
				m_drive.tankDriveRaw(0, 0);
				finished = true;
			}
			else {
				m_drive.tankDriveRaw(-Math.sqrt(speed), Math.sqrt(speed));
			}
		}
		
		
	}
	
	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		m_drive.tankDriveRaw(0, 0);
		finished = false;
		m_drive.resetEncoders();
		m_drive.resetGyro();
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
}
