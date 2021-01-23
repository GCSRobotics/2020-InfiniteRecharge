/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunShooter extends CommandBase {
  private LeftShooterSubPID shooterSubL;
  private RightShooterSubPID shooterSubR;
  private IndexSub indexSub;
  private ShooterSub shooterSub;

  public RunShooter(ShooterSub shooter, LeftShooterSubPID shooterLeft, RightShooterSubPID shooterRight, IndexSub index) {
    shooterSub = shooter;
    shooterSubL = shooterLeft;
    shooterSubR = shooterRight;
    indexSub = index;
    addRequirements(shooterSubL);
    addRequirements(shooterSubR);
    // addRequirements(indexSub);
    addRequirements(shooterSub);
  }
 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSub.shoot();
    indexSub.shootBall();
    // if (!shooterSubL.isEnabled()) {
    //   shooterSubL.enable();
    // }

    // if (!shooterSubR.isEnabled()) {
    //   shooterSubR.enable();
    // }

    // displayEncoderValues();
    
    // if (shooterSubL.atSetpoint() && shooterSubR.atSetpoint()) {
    //   indexSub.indexBall();
    // }
    // else {
    //   indexSub.stopIndex();
    // }
  }

  public void displayEncoderValues() {
    SmartDashboard.putNumber("Left Shooter Velocity", shooterSub.getLeftVelocity());
    SmartDashboard.putNumber("Right Shooter Velocity", shooterSub.getRightVelocity());
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
