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


public class IndexSub extends SubsystemBase {
  private static final WPI_VictorSPX IndexMotor = new WPI_VictorSPX(Constants.IndexMotor);

  /**
   * Creates a new IndexSub.
   */
  public IndexSub() {
    addChild("IndexMotor",IndexMotor);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void indexBall(){
    IndexMotor.set(.60);
  }
  public void reverseIndex(){
    IndexMotor.set(-.60);
  }

  public void stopIndex(){
    IndexMotor.set(0);
  }

}
