/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class ShooterSubPID extends PIDSubsystem {

  private final SpeedController shooterMotor;
  private final Encoder shooterEncoder;

  /**
   * Creates a new ShooterSubPID.
   */
  public ShooterSubPID(SpeedController shooter, Encoder encoder) {
    // Create the PIDController that is integral to the sub system and set it's
    // tolerance
    super(new PIDController(Constants.ShooterP, Constants.ShooterI, Constants.ShooterD));
    getController().setTolerance(Constants.ShooterEncoderTolerance);

    // Setup the motor and encoder
    shooterMotor = shooter;
    shooterEncoder = encoder;

    // Set the encoders default revolutions per pulse used for distance/speed
    // measurements
    shooterEncoder.setDistancePerPulse(1/Constants.ShooterEncoderPPR);

    // Set the defaut speed for the shooter
    setSetpoint(Constants.ShooterDefautTargetRPM);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    shooterMotor.setVoltage(output);
  }

  @Override
  public double getMeasurement() {
    return shooterEncoder.getRate();
  }

  public Encoder getEncoder() {
    return shooterEncoder;
  }
 
  public boolean atSetpoint() {
    return getController().atSetpoint();
  }
}
