package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;

public class TeleportRushEnemy extends MovableEnemy implements AffectedByGravity {
    private  EnemyBehavior<TeleportRushEnemy> behavior;
    private Player player;
    private LevelHandler levelHandler;

    public TeleportRushEnemy(int x, int y, int width, int height) {
        super(GameObjectType.TELEPORT__, x, y,width,height);
        setMovementSpeed(1);
        //this.player = player; // initialize player
        behavior = new EnemyBehavior<>(this);
        //behavior.setPlayer(player);

    }

    public EnemyBehavior<TeleportRushEnemy> getBehavior() {
        return behavior;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {
        behavior.update();
    }

    @Override
    public void move() {}
    

    @Override
    public void updateHealth(int damage) {
    }

    @Override
    public void toggleDirection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggleDirection'");
    }

    public void setTargetCoordinates(int x, int y) {
        behavior.setTargetCoordinates(x, y);
    }

    public int getCurrentState() {
        return behavior.getCurrentState();
    }
}


