/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.ShooterSubPID;

/**
 * Add your docs here.
 */
public class RobotContainer {

    //Drive Subsystem
    public static DriveSub Drive = new DriveSub();

    //Shooter Subsystems
    public static ShooterSubPID ShooterLeft = new ShooterSubPID(
        (SpeedController)new WPI_TalonSRX(Constants.LeftShooterMotor), 
        new Encoder(Constants.LeftEncoderPortA, Constants.LeftEncoderPortB) );
    public static ShooterSubPID ShooterRight = new ShooterSubPID(
        (SpeedController)new WPI_TalonSRX(Constants.RightShooterMotor), 
        new Encoder(Constants.RightEncoderPortA, Constants.LeftEncoderPortB) );

    //Indexer Subsystem
    public static IndexSub Indexer;

    //Operator Interface
    private static OI oi = new OI();
}
