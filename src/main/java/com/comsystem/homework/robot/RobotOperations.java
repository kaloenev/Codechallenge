package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     * algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     * number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     * days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        int numberOfStones = 0;
        List<RobotAction> robotActions = new ArrayList<>();
        if (days == 1) {
            robotActions.add(RobotAction.DIG);
            numberOfStones++;
        } else {
            for (int i = 0; i < days - 2; i++) {
                robotActions.add(RobotAction.CLONE);
            }
            for (int j = days - 2; j < days; j++) {
                robotActions.add(RobotAction.DIG);
            }
        }
        return new RobotPlan(days, numberOfStones, robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     * {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        List<RobotAction> robotActions = new ArrayList<>();
        int days = 0;
        if (numberOfStones <= 2) {
            for (int j = 0; j < numberOfStones; j++) {
                robotActions.add(RobotAction.DIG);
                days++;
            }
            return new RobotPlan(numberOfStones, days, robotActions);
        }
        for (int i = numberOfStones; i > 2; i = i / 2) {
            robotActions.add(RobotAction.CLONE);
            days++;
        }
        days += 2;
        return new RobotPlan(days, numberOfStones, robotActions);
    }
}
