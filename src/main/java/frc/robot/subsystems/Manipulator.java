
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


import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Manipulator extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Spark manipulatorInput;
private Spark manipulatorDeploy;
public NetworkTableEntry inputInverted;
public NetworkTableEntry deployInverted;
private Spark manipulatorRev;

 Encoder deployEncoder;
 Encoder revEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Manipulator() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        manipulatorInput = new Spark(Constants.ManipulatorConstants.inputPort);
        manipulatorInput.setInverted(Constants.ManipulatorConstants.inputInverted);

        
        manipulatorDeploy = new Spark(Constants.ManipulatorConstants.deployPort);
        manipulatorDeploy.setInverted(Constants.ManipulatorConstants.deployInverted);

        inputInverted = Shuffleboard.getTab("Manipulator").add("Invert Input", Constants.ManipulatorConstants.inputInverted).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();
        deployInverted = Shuffleboard.getTab("Manipulator").add("Invert Deploy", Constants.ManipulatorConstants.deployInverted).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();

        inputInverted.addListener(event ->{
            manipulatorInput.setInverted(inputInverted.getBoolean(Constants.ManipulatorConstants.inputInverted));
        }, EntryListenerFlags.kNew | EntryListenerFlags.kImmediate | EntryListenerFlags.kUpdate | EntryListenerFlags.kLocal);

        deployInverted.addListener(event ->{
            manipulatorDeploy.setInverted(deployInverted.getBoolean(Constants.ManipulatorConstants.deployInverted));
        }, EntryListenerFlags.kNew | EntryListenerFlags.kImmediate | EntryListenerFlags.kUpdate | EntryListenerFlags.kLocal);



        manipulatorRev = new Spark(Constants.ManipulatorConstants.revPort);

        deployEncoder = new Encoder(Constants.deployEncoderPorts[0], Constants.deployEncoderPorts[1]);
        deployEncoder.setDistancePerPulse(360/1024);
        revEncoder = new Encoder(Constants.revEncoderPorts[0], Constants.revEncoderPorts[1]);
        revEncoder.setDistancePerPulse(360/1024);

        Shuffleboard.getTab("Manipulator").add((Sendable) deployEncoder);
        Shuffleboard.getTab("Manipulator").add((Sendable) revEncoder);






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

    public void deploySetSpeed(double speed){
        manipulatorDeploy.set(speed);
        
    }

    public void inputSetSpeed(double speed){
        manipulatorInput.set(speed);
        
    }

    public void revSetSpeed(double speed){
        manipulatorRev.set(speed);
    }

    public double deployGetPosition(){
        return deployEncoder.getDistance();
    }

    public double revGetSpeed(){
        return revEncoder.getRate();
    }




   
    


}


