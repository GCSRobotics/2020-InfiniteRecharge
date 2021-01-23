package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ShooterSub;

public class ShootLeftPID extends PIDCommand {

    public ShootLeftPID(ShooterSub shooterSub) {
        super(
            new PIDController(0.1, 0.0, 0.0),
            shooterSub::getLeftVelocity,
            2000.0,
            output -> {
                System.out.println(output);
            },
            shooterSub
        );

        // getController().setTolerance();

    }

}