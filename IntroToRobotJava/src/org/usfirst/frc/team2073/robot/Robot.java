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
			if (controller.getRawButton(1)) {
				speed = .5;
			} else if (controller.getRawButton(2)) {
				speed = -.5;
			} else if (controller.getY() != 0) {
				speed = controller.getY();
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
			} else {
				speed = 0;
			}

			motor.set(speed);
			Timer.delay(.005);
		}
	}

	@Override
	public void test() {
		double motorSpeed = 0;
		while (true) {
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
