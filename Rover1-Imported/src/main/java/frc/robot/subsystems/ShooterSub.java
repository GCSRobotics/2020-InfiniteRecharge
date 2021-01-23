/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {

  private final WPI_TalonSRX leftShooter = new WPI_TalonSRX(Constants.LeftShooterMotor);
  private final WPI_TalonSRX rightShooter = new WPI_TalonSRX(Constants.RightShooterMotor);

  public ShooterSub() {
    this.leftShooter.configFactoryDefault();
    this.rightShooter.configFactoryDefault();

    this.leftShooter.setInverted(true);
    this.rightShooter.setInverted(false);

    // this.leftShooter.configContinuousCurrentLimit(amps);
  }

  public void shoot() {
    this.leftShooter.set(ControlMode.PercentOutput, 1);
    this.rightShooter.set(ControlMode.PercentOutput, 1);
  }

  public void stopShooter() {
    this.leftShooter.set(0);
    this.rightShooter.set(0);
  }

  public void shootLeft() {
    this.leftShooter.set(ControlMode.PercentOutput, 1.0);
  }

  public void shootRight() {
    this.rightShooter.set(ControlMode.PercentOutput, 1.0);
  }

  public double getLeftVelocity() {
    return this.leftShooter.getSelectedSensorVelocity();
  }

  public double getRightVelocity() {
    return this.rightShooter.getSelectedSensorVelocity();
  }

  public double getLeftPosition() {
    return this.leftShooter.getSelectedSensorPosition();
  }

  public double getRightPosition() {
    return this.rightShooter.getSelectedSensorPosition();
  }

}