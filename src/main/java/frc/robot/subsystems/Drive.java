// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private PWMSparkMax leftMotor;
private PWMSparkMax rightMotor;
private DifferentialDrive m_differentialDrive;
private Encoder leftEncoder;
private Encoder rightEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftMotor = new PWMSparkMax(Constants.DriveConstants.leftMotorPort);
        leftMotor.setInverted(Constants.DriveConstants.leftMotorInverted);

        rightMotor = new PWMSparkMax(Constants.DriveConstants.rightMotorPort);
        rightMotor.setInverted(Constants.DriveConstants.rightMotorInverted);

        m_differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("Differential Drive 1",m_differentialDrive);
        m_differentialDrive.setSafetyEnabled(true);
        m_differentialDrive.setExpiration(0.1);
        m_differentialDrive.setMaxOutput(1.0);


        leftEncoder = new Encoder(Constants.DriveConstants.leftEncoder1, Constants.DriveConstants.leftEncoder2, Constants.DriveConstants.leftEncoderInverted, EncodingType.k4X);
        leftEncoder.setDistancePerPulse(Constants.DriveConstants.distancePerPulse);

        rightEncoder = new Encoder(Constants.DriveConstants.rightEncoder1, Constants.DriveConstants.rightEncoder2, Constants.DriveConstants.rightEncoderInverted, EncodingType.k4X);
        rightEncoder.setDistancePerPulse(Constants.DriveConstants.distancePerPulse);


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void tankDriveRaw(double leftSpeed, double rightSpeed){
        m_differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public double[] getEncoderDistance(){
        double[] distances={leftEncoder.getDistance(), rightEncoder.getDistance()};
        return distances;
    }

    public double[] getEncoderRates(){
        double[] rates={leftEncoder.getRate(), rightEncoder.getRate()};
        return rates;
    }

    
}

