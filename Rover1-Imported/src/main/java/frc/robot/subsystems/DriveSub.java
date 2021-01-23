/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;


public class DriveSub extends SubsystemBase {
  private static final WPI_VictorSPX LeftFrontMotor = new WPI_VictorSPX(Constants.LeftFrontDrive);
  private static final WPI_VictorSPX RightFrontMotor = new WPI_VictorSPX(Constants.RightFrontDrive);
  private static final WPI_VictorSPX LeftRearMotor = new WPI_VictorSPX(Constants.LeftRearDrive);
  private static final WPI_VictorSPX RightRearMotor = new WPI_VictorSPX(Constants.RightRearDrive);
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.005; // propotional turning constant

  private static final ADXRS450_Gyro Gyro = new ADXRS450_Gyro(Constants.Gyro);
  // public final AHRS ahrs = new AHRS(SPI.Port.kMXP);

  private final SpeedControllerGroup speedControllerGroupLeft = 
    new SpeedControllerGroup(LeftFrontMotor, LeftRearMotor);
  private final SpeedControllerGroup speedControllerGroupRight = 
    new SpeedControllerGroup(RightFrontMotor, RightRearMotor);
  private final DifferentialDrive robotDrive = 
    new DifferentialDrive(speedControllerGroupRight, speedControllerGroupLeft);

  private final Encoder leftDriveEncoder = new Encoder(Constants.LeftDriveEncoderPortA, Constants.LeftDriveEncoderPortB);
  private final Encoder rightDriveEncoder = new Encoder(Constants.RightDriveEncoderPortA, Constants.RightDriveEncoderPortB);

  /**
   * Creates a new ExampleSubsystem.
   */
  public DriveSub() {
    addChild("LeftFront",LeftFrontMotor);
    addChild("LeftRear", LeftRearMotor);
    addChild("RightFront", RightFrontMotor);
    addChild("RightRear", RightRearMotor);
    addChild("ControllerLeft",speedControllerGroupLeft);
    addChild("ControllerRight", speedControllerGroupRight);
    addChild("Gyro", Gyro);
   // addChild("AHRS", ahrs);
    addChild("LeftDriveEncoder", leftDriveEncoder); 
    addChild("RightDriveEncoder", rightDriveEncoder);

    leftDriveEncoder.setDistancePerPulse((2*Math.PI*3)/Constants.DriveEncoderPPR);
    rightDriveEncoder.setDistancePerPulse((2*Math.PI*3)/Constants.DriveEncoderPPR);
    resetEncoders();
  }
 
   public void calibrate(){
     Gyro.calibrate();
  //   ahrs.calibrate();
   }
  
  public void arcadeDrive(Joystick joy) {
    robotDrive.arcadeDrive(joy.getY(), joy.getRawAxis(4), true);
  }

  public void arcadeDrive(double speedAxis, double rotationAxis) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, true);
  }
  public void arcadeDrive(double speedAxis, double rotationAxis, boolean squared) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, squared);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    robotDrive.arcadeDrive(0, 0);
  }

  public void driveStraight(double speed) {
    double turningValue = (kAngleSetpoint - Gyro.getAngle()) * kP;
    // double turningValue = (kAngleSetpoint - ahrs.getAngle()) * kP;
		// Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, speed);
		robotDrive.arcadeDrive(speed, turningValue);
  }

  public void resetEncoders() {
    leftDriveEncoder.reset();
    rightDriveEncoder.reset();
  }

  public double getDistance() {
    return leftDriveEncoder.getDistance();
  }

  public void turnTo(float angle) {
    double turningValue = (angle - Gyro.getAngle()) * kP;
    // double turningValue = (angle - ahrs.getAngle()) * kP;
    robotDrive.arcadeDrive(0, turningValue);
  }
}
