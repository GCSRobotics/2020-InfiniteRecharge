/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoCenterStart;
import frc.robot.commands.DriveWithController;
import frc.robot.subsystems.*;

/**
 * Add your docs here.
 */
public class RobotContainer {

    //Drive Subsystem
    public static DriveSub Drive = new DriveSub();

    //Climber Subsystem
    public static ClimberSub Climber = new ClimberSub();

    //Shooter Subsystems
    public static ShooterSub Shooter = new ShooterSub();
    public static LeftShooterSubPID ShooterLeft = new LeftShooterSubPID(
        new WPI_TalonSRX(Constants.LeftShooterMotor), 
        new Encoder(Constants.LeftEncoderPortA, Constants.LeftEncoderPortB));
    public static RightShooterSubPID ShooterRight = new RightShooterSubPID(
        new WPI_TalonSRX(Constants.RightShooterMotor), 
        new Encoder(Constants.RightEncoderPortA, Constants.RightEncoderPortB));

    //Indexer Subsystem
    public static IndexSub Indexer = new IndexSub();

    //Intake Subsystem
    public static IntakeSub Intake = new IntakeSub();

    //Operator Interface
    private static OI oi = new OI();
       
    private final Command autoCommand = new AutoCenterStart(Drive, 35, ShooterLeft, ShooterRight, Indexer);

    public Command getAutonomousCommand() {
        return autoCommand;
    }

    public void setTeleopDefaultCommands() {
        Drive.setDefaultCommand(new DriveWithController(Drive, oi.GetDriverControl()));
    }
}
