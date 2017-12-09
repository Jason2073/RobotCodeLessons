package org.usfirst.frc.team2073.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	private Joystick controller = new Joystick(0);
	private CANTalon motor = new CANTalon(4);
	private double speed = 0;

	@Override
	public void robotInit() {

	}

	@Override
	public void autonomous() {

	}

	@Override
	public void operatorControl() {
		while (true) {
//			if you press button 1, set speed to .5;
			if (controller.getRawButton(1)) {
				speed = .5;	
//				otherwise, if you press button 2, set speed to .5 in the other direction;
			} else if (controller.getRawButton(2)) {
				speed = -.5;
//				if you aren't pressing button 1 or 2, and you are moving the joystick, set speed = the joystick value (1 is full forward, -1 is full back)
			} else if (controller.getY() != 0) {
				speed = controller.getY();
//				if you press button 3, do this series of commands. 
			} else if (controller.getRawButton(3)) {
				motor.set(.5);
				Timer.delay(1);
				motor.set(0);
				Timer.delay(.2);
				motor.set(-1);
				Timer.delay(1);
				motor.set(0);
				Timer.delay(.5);
				motor.set(1);
				Timer.delay(.5);
//				if you are not pressing buttons 1,2 or 3, and not moving the joystick, don't move
			} else {
				speed = 0;
			}
// this line actually tells the motor to go the speed that we set earlier.
			motor.set(speed);
//			This delay is the cycle time the robot operates on.
			Timer.delay(.005);
		}
	}

	@Override
	public void test() {
		double motorSpeed = 0;
		while (true) {
//			from what you learned earlier, what should this code do?
			
			if (controller.getPOV() == 0) {
				motorSpeed = 1;
			} else if (controller.getPOV() == 45) {
				motorSpeed = .5;
			} else if (controller.getPOV() == 0) {
				motorSpeed = 0;
			} else if (controller.getPOV() == 135) {
				motorSpeed = -.5;
			} else if (controller.getPOV() == 180) {
				motorSpeed = -1;
			} else {
				motorSpeed = 0;
			}
			motor.set(motorSpeed);
			Timer.delay(.005);
		}

	}
}
