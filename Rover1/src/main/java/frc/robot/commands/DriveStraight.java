/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.controllers.BaseController;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ShooterSub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DriveStraight extends CommandBase {
  private final DriveSub driveSub;
  private final double speed;
  private final double distance;
  private final ShooterSub shooter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveStraight(DriveSub subsystem, ShooterSub shooterSub, Double distanceToTravel) {
    driveSub = subsystem;
    shooter = shooterSub;
    distance = Math.abs(distanceToTravel);
    SmartDashboard.putNumber("Distance To Drive", distance);
   
    if (distanceToTravel < 0) {
      speed = -.7;
    } else {
      speed = .7;
    }
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSub.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shoot();
    driveSub.driveStraight(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSub.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putNumber("Distance To Driven", driveSub.getDistance());
    if (Math.abs(driveSub.getDistance()) >= distance) {
      return true;
    }
    return false;
  }
}
