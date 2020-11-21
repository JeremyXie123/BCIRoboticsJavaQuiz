package com.arctos6135.robot;
import com.arctos6135.robot.sensors.Encoder;
import com.arctos6135.robot.sensors.Gyroscope;

import com.arctos6135.robot.actuators.Motor;

enum OperationState {
    ENABLED, DISABLED, UNKNOWN;
}

public class Robot extends AbstractRobot{
    Motor LeftMotor = new Motor(0);    
    Motor RightMotor = new Motor(1);
    Encoder LeftEncoder = new Encoder(2);
    Encoder RightEncoder = new Encoder(3);
    Gyroscope Gyro = new Gyroscope(4); 
    
    OperationState RobotState;

    Robot(String name) {
        this.RobotState = OperationState.DISABLED;
        setName(name);
    }

    public double getLeftWheelDistance() {
        return LeftEncoder.getReading() / 2.54;
    }

    public double getRightWheelDistance() {
        return RightEncoder.getReading() / 2.54;
    }

    public double getHeading() {
        return Gyro.getReading() % 360;
    }

    public OperationState getState() {
        return this.RobotState;
    }

    public void setState(OperationState State) {
        this.RobotState = State;
    }

}
