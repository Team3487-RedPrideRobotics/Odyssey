
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
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Climbing extends SubsystemBase {
    private Spark middleHook;
    private Spark leftHook;
    private Spark rightHook;
    private DigitalInput backLimitSwitch;
    private DigitalInput frontLimitSwitch;
    public NetworkTableEntry middleHookEntry;
    public NetworkTableEntry elevatedHookEntry;
    private NetworkTableEntry limitSwitchEntry;
        
    public Climbing() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        middleHook = new Spark(Constants.ClimbConstants.slidingPort);
        middleHook.setInverted(Constants.ClimbConstants.slidingHookInverted);
        leftHook =  new Spark(Constants.ClimbConstants.leftHook);
        rightHook = new Spark(Constants.ClimbConstants.rightHook);
        backLimitSwitch = new DigitalInput(Constants.ClimbConstants.leftLSPort);
        Shuffleboard.getTab("Climber").add((Sendable) backLimitSwitch);
        frontLimitSwitch= new DigitalInput(Constants.ClimbConstants.rightLSPort);

        elevatedHookEntry = Shuffleboard.getTab("Climber").add("Invert Elevated Hooks",Constants.ClimbConstants.elevatedHookInverted).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();
        middleHookEntry = Shuffleboard.getTab("Climber").add("Invert Sliding Hook",Constants.ClimbConstants.slidingHookInverted).withWidget(BuiltInWidgets.kToggleSwitch).getEntry();
        
        elevatedHookEntry.addListener(event ->{
            leftHook.setInverted(elevatedHookEntry.getBoolean(Constants.ClimbConstants.elevatedHookInverted));
            rightHook.setInverted(elevatedHookEntry.getBoolean(Constants.ClimbConstants.elevatedHookInverted));
        }, EntryListenerFlags.kNew | EntryListenerFlags.kImmediate | EntryListenerFlags.kUpdate | EntryListenerFlags.kLocal);

        middleHookEntry.addListener(event ->{
            middleHook.setInverted(middleHookEntry.getBoolean(Constants.ClimbConstants.slidingHookInverted));
        }, EntryListenerFlags.kNew | EntryListenerFlags.kImmediate | EntryListenerFlags.kUpdate | EntryListenerFlags.kLocal);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        //if(backLimitSwitch.get() && middleHook.get() < 0 || frontLimitSwitch.get() && middleHook.get() > 0){
        //        middleHook.set(0);
        //}
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setSlidingSpeed(double speed){
        //if(backLimitSwitch.get() && speed < 0 || frontLimitSwitch.get() && speed > 0){
         //   middleHook.set(0);
        //}else{
            middleHook.set(speed);
        //}
    } 

    public void setLeftHookSpeed(double speed){
        leftHook.set(speed);
    }

    public void setRightHookSpeed(double speed){
        rightHook.set(speed);
    }
}
