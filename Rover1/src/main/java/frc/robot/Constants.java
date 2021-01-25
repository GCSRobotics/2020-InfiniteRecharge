/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Climb Constants

    // Motor Constants
    public final static int LeftFrontDrive = 0;
    public final static int RightFrontDrive = 2;
    public final static int LeftRearDrive = 1;
    public final static int RightRearDrive = 3;
    public final static int IndexMotor = 4;
    public final static int IntakeMotor = 5;
    public final static int LeftShooterMotor = 6;
    public final static int RightShooterMotor = 7 ;
    public final static int ClimberMotor = 8;

    public final static int LeftDriveEncoderPortA = 4;
    public final static int LeftDriveEncoderPortB = 5;
    public final static int RightDriveEncoderPortA = 6;
    public final static int RightDriveEncoderPortB = 7;
    public static final double DriveEncoderPPR = 2048;

    // Intake Constants
    
    public final static int IntakeSolenoidChannel1 = 0;
    public final static int IntakeSolenoidChannel2 = 1;

    // Index Constants
   

    // Shooter Constants
   
	public static final double ShooterP = .15;
	public static final double ShooterI = 0;
	public static final double ShooterD = 0;
    public static final double ShooterEncoderTolerance = 5;
    public static final double ShooterEncoderPPR = 2048;
    public static final double ShooterDefaultTargetRPM = 100;

    public final static int LeftEncoderPortA = 0;
    public final static int LeftEncoderPortB = 1;
    public final static int RightEncoderPortA = 2;
    public final static int RightEncoderPortB = 3;
    public final static int shooterCamera = 0;

    public final static SPI.Port Gyro = SPI.Port.kOnboardCS0;

    public final static int DriveJoystick = 0;
    public final static int OperatorJoystick = 1;

    public final static I2C.Port i2cPort = I2C.Port.kOnboard;
   
    public final static Color  kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public final static Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public final static Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public final static Color YellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
	
	
	


}

