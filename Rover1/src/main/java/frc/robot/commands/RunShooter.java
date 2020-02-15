/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.ShooterSubPID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunShooter extends CommandBase {
  private ShooterSubPID shooterSubL;
  private ShooterSubPID shooterSubR;
  private IndexSub indexSub;

  public RunShooter(ShooterSubPID shooterLeft, ShooterSubPID shooterRight, IndexSub index) {
    shooterSubL = shooterLeft;
    shooterSubR = shooterRight;
    indexSub = index;
    addRequirements(shooterSubL);
    addRequirements(shooterSubR);
    addRequirements(indexSub);
  }
 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!shooterSubL.isEnabled()) {
      shooterSubL.enable();
    }

    if (!shooterSubR.isEnabled()) {
      shooterSubR.enable();
    }

    displayEncoderValues();
    
    if (shooterSubL.atSetpoint() && shooterSubR.atSetpoint()) {
      indexSub.indexBall();
    }
    else {
      indexSub.stopIndex();
    }
  }

  public void displayEncoderValues() {
    SmartDashboard.putNumber("Left Shooter RPM", shooterSubL.getEncoder().getRate());
    SmartDashboard.putNumber("Right Shooter RPM", shooterSubR.getEncoder().getRate());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubL.disable();
    shooterSubR.disable();
    indexSub.stopIndex();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
