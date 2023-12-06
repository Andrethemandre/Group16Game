package org.group16.Model.GameObjects.Goal;

import org.group16.Model.GameObjects.GameObjectType;

public class GoalFactory {
    public static IGoal createGoalAt(GameObjectType goalType, int x, int y) {
        switch(goalType) {
            case GOAL______:
                return new Goal(x, y);
            default:
                throw new IllegalArgumentException("Invalid goal Type");
        }
    }
}
