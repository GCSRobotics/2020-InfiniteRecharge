/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
  private static final WPI_VictorSPX IntakeMotor = new WPI_VictorSPX(Constants.IntakeMotor);
  // private static final DoubleSolenoid solenoid = new DoubleSolenoid(Constants.IntakeSolenoidChannel1,
      // Constants.IntakeSolenoidChannel2);

  /**
   * Creates a new IntakeSub.
   */
  public IntakeSub() {
    addChild("IntakeMotor", IntakeMotor);
    // addChild("solenoid", solenoid);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stopIntake() {
    IntakeMotor.set(0);
  }
 
  public void runIntake(){
    IntakeMotor.set(-.5);
  }
 
  public void reverseIntake(){
    IntakeMotor.set(.4);
  }
 
  public void extendIntake(){
    // solenoid.set(DoubleSolenoid.Value.kForward);
  }
 
  public void retractIntake(){
    // solenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
