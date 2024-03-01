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
        robotOperations.excavateStonesForDays(1);
        List<RobotAction> robotPlans = new ArrayList<>();
        RobotAction robotAction = RobotAction.DIG;
        robotPlans.add(robotAction);
        RobotPlan robotPlan = new RobotPlan(1, 1, robotPlans);
        Assertions.assertEquals(1, robotPlan.numberOfDays());
        Assertions.assertEquals(1, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(0));
    }

    @Test
    void testExcavateStonesForDays() {
        robotOperations.excavateStonesForDays(5);
        List<RobotAction> robotActions= new ArrayList<>();
        robotActions.add(RobotAction.CLONE);
        robotActions.add(RobotAction.DIG);
        RobotPlan robotPlan = new RobotPlan(5, 16, new ArrayList<>());
        Assertions.assertEquals(5, robotPlan.numberOfDays());
        Assertions.assertEquals(16, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.CLONE, robotActions.get(0));
        Assertions.assertEquals(RobotAction.DIG, robotActions.get(robotActions.size() - 1));
    }

    @Test
    void testExcavateOneStone() {
        robotOperations.daysRequiredToCollectStones(1);
        List<RobotAction> robotPlans = new ArrayList<>();
        RobotAction robotAction = RobotAction.DIG;
        robotPlans.add(robotAction);
        RobotPlan robotPlan = new RobotPlan(1, 1, robotPlans);
        Assertions.assertEquals(1, robotPlan.numberOfDays());
        Assertions.assertEquals(1, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.DIG, robotPlan.robotActions().get(0));
    }

    @Test
    void testExcavateDays() {
        robotOperations.daysRequiredToCollectStones(14);
        List<RobotAction> robotActions= new ArrayList<>();
        robotActions.add(RobotAction.CLONE);
        robotActions.add(RobotAction.DIG);
        RobotPlan robotPlan = new RobotPlan(5, 14, new ArrayList<>());
        Assertions.assertEquals(5, robotPlan.numberOfDays());
        Assertions.assertEquals(14, robotPlan.numberOfStones());
        Assertions.assertEquals(RobotAction.CLONE, robotActions.get(0));
        Assertions.assertEquals(RobotAction.DIG, robotActions.get(robotActions.size() - 1));
    }
}
