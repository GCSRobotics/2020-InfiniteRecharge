/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {
  private static final WPI_TalonSRX LeftShooterMotor = new WPI_TalonSRX(Constants.LeftShooterMotor);
  private static final WPI_TalonSRX RightShooterMotor = new WPI_TalonSRX(Constants.RightShooterMotor);
 // private static final WPI_VictorSPX PrimerMotor = new WPI_VictorSPX(Constants.PrimerMotor);

  /**
   * Creates a new ShooterSub.
   */
  public ShooterSub() {
    addChild("LeftShooterMotor",LeftShooterMotor);
    addChild("RightShooterMotor",RightShooterMotor);
    //addChild("PrimerMotor",PrimerMotor);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(){
    LeftShooterMotor.set(1);
    RightShooterMotor.set(-1);
    //Code PID loop to make this work
  }

  public void stopShooter(){
    LeftShooterMotor.set(0);
    RightShooterMotor.set(0);
  }
  
  //public void primeShooter(){
   // PrimerMotor.set(.5);
 // }
}
