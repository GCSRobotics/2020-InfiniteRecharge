/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ShooterSubPID extends PIDSubsystem {
  private static final WPI_TalonSRX LeftShooterMotor = new WPI_TalonSRX(Constants.LeftShooterMotor);
  private static final WPI_TalonSRX RightShooterMotor = new WPI_TalonSRX(Constants.RightShooterMotor);

  private final Encoder leftEncoder = new Encoder(Constants.LeftEncoderPortA,Constants.LeftEncoderPortB);

  /**
   * Creates a new ShooterSubPID.
   */
  public ShooterSubPID() {
    super(new PIDController(Constants.ShooterP, Constants.ShooterI, Constants.ShooterD));
    getController().setTolerance(Constants.ShooterEncoderTolerance);
    leftEncoder.setDistancePerPulse(Constants.EncoderDistancePerPulse);
    setSetpoint(Constants.ShooterSpeedRPM);

    RightShooterMotor.follow(LeftShooterMotor);
    
   }

  @Override
  public void useOutput(double output, double setpoint) {
   LeftShooterMotor.setVoltage(output);

    
    // Use the output here
  }

  @Override
  public double getMeasurement() {
    return leftEncoder.getRate();
  }
}
