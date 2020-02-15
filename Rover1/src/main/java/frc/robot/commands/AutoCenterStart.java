/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.RunShooter;
import frc.robot.controllers.BaseController;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.ShooterSubPID;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoCenterStart extends SequentialCommandGroup {
  /**
   * Creates a new AutoCenterStart.
   */
  public AutoCenterStart(DriveSub driveSub, BaseController controller, double distance, ShooterSubPID shooterLeft, ShooterSubPID shooterRight, IndexSub indexSub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new DriveStraight(driveSub, controller, distance),
      new RunShooter(shooterLeft, shooterRight, indexSub)
    );
  }
}
