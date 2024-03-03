package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RobotOperationsTest {
    public RobotOperations robotOperations = new RobotOperations();

    @Test
    void testExcavateStonesForOneDay() {
        // Checks the case where the robot has only 1 day for the task -> the robots digs without cloning
        RobotPlan robotPlan = robotOperations.excavateStonesForDays(1);
        Assertions.assertEquals(1, robotPlan.numberOfDays());
        Assertions.assertEquals(1, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(0));
    }

    @Test
    void testExcavateStonesForDays() {
        // Asserts the days and stones are equal to the expected values and checks the first and last action
        // the expected actions are explained in the ReadMe file
        RobotPlan robotPlan = robotOperations.excavateStonesForDays(6);
        Assertions.assertEquals(6, robotPlan.numberOfDays());
        Assertions.assertEquals(32, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.CLONE, robotPlan.robotActions().get(0));
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(robotPlan.robotActions().size() - 1));
    }

    @Test
    void testExcavateOneStone() {
        // Checks the case where 1 stone needs to be collected -> the robots digs without cloning
        RobotPlan robotPlan = robotOperations.daysRequiredToCollectStones(1);
        Assertions.assertEquals(1, robotPlan.numberOfDays());
        Assertions.assertEquals(1, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(0));
    }

    @Test
    void testExcavateDays() {
        RobotPlan robotPlan = robotOperations.daysRequiredToCollectStones(14);
        // Asserts the days and stones are equal to the expected values and checks the first and last action
        // the expected actions are explained in the ReadMe file
        Assertions.assertEquals(5, robotPlan.numberOfDays());
        Assertions.assertEquals(14, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.CLONE, robotPlan.robotActions().get(0));
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(robotPlan.robotActions().size() - 1));
    }
}
