package com.arctos6135.robot;

public class Tester {
    public static void main(String[] args) {
        Robot testRobot = new Robot("Test");
        try {
            testRobot.doSomethingCool();
        } 
        catch (NameNotSetException e) {
            return;
        }
        finally {
            Task task = (AbstractRobot curRobot)->{
                Robot robot = (Robot) curRobot;
                OperationState robotState = robot.getState();
                switch(robotState) {
                    case DISABLED:
                        robot.LeftMotor.setOutput(1);
                        robot.RightMotor.setOutput(1);
                        break;
                    case ENABLED:
                        break;
                    case UNKNOWN:
                        throw new TaskExecutionException("Robot state is Unknown. Robot Operation");
                }
            };
            testRobot.doTask(task);
        }
    }
}
