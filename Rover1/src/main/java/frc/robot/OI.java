/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.RunShooter;
import frc.robot.controllers.BaseController;

/**
 * Add your docs here.
 */
public class OI {
    private BaseController DriverControl;
    private BaseController OperatorControl;
  
    public OI() {
      ControllerInit(ControllerType.XBox, ControllerType.XBox);
    }
  
    public OI(ControllerType driveType, ControllerType operatorType) {
      ControllerInit(driveType, operatorType);
    }
  
    private void ControllerInit(ControllerType driveCtrlType, ControllerType operateCtrlType) {
      DriverControl = BaseController.CreateInstance(driveCtrlType, Constants.DriveJoystick);
      OperatorControl = BaseController.CreateInstance(operateCtrlType, Constants.OperatorJoystick);
      ButtonActionInit();
    }
  
    private void ButtonActionInit() {
  
      // Driver buttons.
      //DriverControl.ButtonY.whenHeld(new RunShooter(RobotContainer.Shooter, Robot.Indexer));
    }
    public BaseController GetDriverControl() {
      return DriverControl;
    }
  
    public BaseController GetOperatorControl() {
      return OperatorControl;
    }
  }
  