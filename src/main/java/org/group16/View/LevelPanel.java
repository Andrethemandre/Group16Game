package org.group16.View;

import java.awt.*;
import java.util.Collection;

import org.group16.Controller.PlayerController;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.Level;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class LevelPanel extends GamePanel implements GameObserver {
    private LevelHandler levelHandler;

    public LevelPanel(int x, int y, Level level) {
        super(x, y);
        this.levelHandler = levelHandler;
    }

    public Player getPlayer() {
        return levelHandler.getPlayer();
    }

    @Override
    public void render(Graphics g) {
        // render the grid
        int cellSize = 32; // hard coded
        g.setColor(new Color(0, 0.5f, 0, 0.75f));
        for (int i = 0; i <= levelHandler.WIDTH; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, levelHandler.HEIGHT * cellSize);
            if (i <= levelHandler.WIDTH)
                g.drawLine(0, i * cellSize, levelHandler.WIDTH * cellSize, i * cellSize);
        }
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the grid
        int cellSize = 32; // hard coded
        g.setColor(Color.red);
        for (int i = 0; i <= levelHandler.WIDTH; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, levelHandler.HEIGHT * cellSize);
            if (i <= levelHandler.WIDTH)
                g.drawLine(0, i * cellSize, levelHandler.WIDTH * cellSize, i * cellSize);
        }

        // paint the player
        g.setColor(Color.blue);
        Player currentPlayer = levelHandler.getPlayer();
        int playerX = (int) (5 * cellSize);
        int playerY = (int) (5 * cellSize);
        g.fillRect(playerX + 2, playerY + 2, playerX - 4, playerY - 4);

        // paint the enemies

        // basic enemies
        g.setColor(Color.red);
        Collection<Enemy> currentEnemies = levelHandler.getEnemies();
        for(Enemy enemy: currentEnemies){
            int enemyX = (int) (enemy.getX() * cellSize);
            int enemyY = (int) (enemy.getY() * cellSize);
            g.fillOval(enemyX + 100, enemyY + 100, enemyX - 2, enemyY - 2);
        }

        // spike enemies
        g.setColor(Color.darkGray);


        int[] xPoints = {40,80,60};
        int[] yPoints = {70,70,40};
        int nPoints = 3;

        g.fillPolygon(xPoints,yPoints,nPoints);

        // paint the blocks
        g.setColor(Color.ORANGE);
        Collection<Block> currentBlocks = levelHandler.getBlocks();
        
        for(Block block: currentBlocks){
            int blockX = (int) (block.getX() * cellSize);
            int blockY = (int) (block.getY() * cellSize);
            g.fillRect(blockX + 5, blockY + 5, blockX - 5, blockY - 5);
        }

        // paint the healthbar
        int health = currentPlayer.getHealth();
        int maxHealth = 10; // Assuming there's a constant for max health in your Player class
        int barWidth = (int) ((double) health * cellSize / maxHealth * 5);

        g.setColor(Color.RED);
        g.fillRect(0, 0, health, 80);
    }

    @Override
    public void updateObserver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateObserver'");
    }

}
