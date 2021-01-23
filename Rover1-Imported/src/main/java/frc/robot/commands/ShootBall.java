/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ShooterSub;
import frc.robot.subsystems.IndexSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootBall extends SequentialCommandGroup {
  /**
   * Creates a new ShootBall.
   */
  public ShootBall(final ShooterSub shooterSub, final IndexSub indexSub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new StartShooter(shooterSub).withTimeout(.7),
      new FeedShooter(indexSub, shooterSub).withTimeout(3)
    );
  }
}
