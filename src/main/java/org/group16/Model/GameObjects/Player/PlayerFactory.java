package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.GameObjectType;

public class PlayerFactory {
    public static IPlayer createPlayerAt(GameObjectType playerType, int x, int y, int maxX, int maxY) {
        switch(playerType) {
            case PLAYER____:
                return new Player(x, y, maxX, maxY);
            default:
                throw new IllegalArgumentException("Invalid player Type");
        }
    }
}
