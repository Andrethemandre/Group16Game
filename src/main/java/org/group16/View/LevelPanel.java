package org.group16.View;

import java.awt.*;
import java.util.Collection;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class LevelPanel extends GamePanel implements GameObserver {
    private LevelHandler levelHandler;

    public LevelPanel(int x, int y, LevelHandler levelHandler) {
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
        for (int i = 0; i <= levelHandler.getHeight(); i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, levelHandler.getHeight()* cellSize);
            if (i <= levelHandler.getWidth())
                g.drawLine(0, i * cellSize, levelHandler.getWidth() * cellSize, i * cellSize);
        }
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the grid
        int cellSize = 16; // hard coded
        paintGridWithSize(g, cellSize);
        
        Player currentPlayer = levelHandler.getPlayer();
        paintPlayer(g, currentPlayer);

        paintEnemies(g);

        paintBlocks(g);

        paintFlag(g);

        // paint the healthbar
        int health = currentPlayer.getHealth();
        int maxHealth = 10; // Assuming there's a constant for max health in your Player class
        int barWidth = (int) ((double) health * cellSize / maxHealth * 5);

        g.setColor(Color.RED);
        g.fillRect(0, 0, health, 80);
    }

    private void paintGridWithSize(Graphics g, int cellSize) {
        g.setColor(Color.red);
        for (int i = 0; i <= levelHandler.getWidth(); i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, levelHandler.getHeight() * cellSize);
            if (i <= levelHandler.getWidth())
                g.drawLine(0, i * cellSize, levelHandler.getWidth() * cellSize, i * cellSize);
        }
    }

    private void paintPlayer(Graphics g, Player currentPlayer) {
        g.setColor(Color.blue);
        int playerX = currentPlayer.getX();
        int playerY = currentPlayer.getY();
        // System.out.println(playerX + " " + playerY + " " + currentPlayer.getWidth() + " " + currentPlayer.getHeight());
        g.fillRect(playerX, playerY, currentPlayer.getWidth(), currentPlayer.getHeight());
    }

    private void paintEnemies(Graphics g) {
        Collection<Enemy> currentEnemies = levelHandler.getEnemies();
        for (Enemy enemy : currentEnemies) {
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();

            // For basic enemies
            if (enemy.getType() == GameObjectType.BASIC_____) {
                g.setColor(Color.red);
                g.fillOval(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
            // For spike
            } else if (enemy.getType() == GameObjectType.SPIKE_____) {
                int[] xPoints = {enemyX, enemyX + (enemyWidth / 2), enemyX + enemyWidth};
                int[] yPoints = {enemyY + enemyHeight, enemyY, enemyY + enemyHeight};
                int nPoints = 3;
                g.setColor(Color.darkGray);
                g.fillPolygon(xPoints, yPoints, nPoints);
            // Default colour and shape
            } else {
                g.setColor(Color.black);
                g.fillRect(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
            }
        }
    }

    private void paintBlocks(Graphics g) {
        Collection<Block> currentBlocks = levelHandler.getBlocks();
        for (Block block : currentBlocks) {
            int blockX = (int) block.getX();
            int blockY = (int) block.getY();
            //System.out.println(blockX + " " + blockY );
            g.setColor(Color.ORANGE);
            g.fillRect(blockX, blockY, block.getWidth(), block.getHeight());
        }
    }

    private void paintFlag(Graphics g) {
        Flag flag = levelHandler.getGoalFlag();
        int flagX = flag.getX();
        int flagY = flag.getY();
        g.setColor(Color.green);
        g.fillRect(flagX, flagY, flag.getWidth(), flag.getHeight());
    }


    @Override
    public void updateObserver() {
        // TODO Auto-generated method stub
        repaint();
    }

}
