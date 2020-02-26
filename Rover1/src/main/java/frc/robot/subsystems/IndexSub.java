/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.SPILink;


public class IndexSub extends SubsystemBase {
  private static final WPI_VictorSPX IndexMotor = new WPI_VictorSPX(Constants.IndexMotor);
  private static final Pixy2 pixy = Pixy2.createInstance(new SPILink());
  private static final int blockSignature = 1;
  private Block lastBlock = null;


  /**
   * Creates a new IndexSub.
   */
  public IndexSub() {
    pixy.init();
    pixy.setLamp((byte) 1, (byte) 1);
		pixy.setLED(255, 255, 255);
    addChild("IndexMotor",IndexMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    int blockCount = pixy.getCCC().getBlocks();
    if (blockCount == 0) {
      return;
    }
    ArrayList<Block> blocks = pixy.getCCC().getBlockCache();
    for (Block block : blocks) {
      //calculate
      if (block.getSignature() == blockSignature) {
        if (lastBlock == null && block.getHeight() > pixy.getFrameHeight()/2) {
          lastBlock = block;
          indexBall();
        }
        if (lastBlock != null && block.getHeight() == 1) {
          lastBlock = null;
          stopIndex();
        }

      }
    }
  }

  public void shootBall() {
    IndexMotor.set(.4);
  }

  public void indexBall(){
    IndexMotor.set(.3);
  }
  
  public void reverseIndex(){
    IndexMotor.set(-.3);
  }

  public void stopIndex(){
    IndexMotor.set(0);
  }

}
