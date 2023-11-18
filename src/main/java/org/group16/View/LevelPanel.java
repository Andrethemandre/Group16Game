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

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the grid
        int cellSize = 16; // hard coded
        //paintGridWithSize(g, cellSize);
        
        Player currentPlayer = levelHandler.getPlayer();
        paintPlayer(g, currentPlayer);
        paintEnemies(g);
        paintBlocks(g);
        paintFlag(g);
        paintHealthBar(g, cellSize, currentPlayer);
        paintStats(g, currentPlayer);

        if(levelHandler.getPauseState()){
            paintPaused(g);
        }

    }

    private void paintPaused(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString("PAUSED", 250, 250);

    }

    // In your game's main class
    public void paintStats(Graphics g, Player currentPlayer) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Deaths: " + String.valueOf(levelHandler.getDeaths()), 55, 20);
        g.drawString("Score: " + String.valueOf(levelHandler.getScore()), 55, 40);
        g.drawString("Time: " + formatTime(levelHandler.getElapsedTime()), 55, 60);
        g.drawString("Level: " + levelHandler.getCurrentLevelNumber(), 55, 80);
    }

    private void paintHealthBar(Graphics g, int cellSize, Player currentPlayer) {
        // paint the healthbar
        int health = currentPlayer.getHealth();
        int maxHealth = 10; // Assuming there's a constant for max health in your Player class
        int barWidth = (int) ((double) health * cellSize / maxHealth * 5);

        g.setColor(Color.RED);
        g.fillRect(0, 0, health*cellSize, 80);
    }
    
    private void paintGridWithSize(Graphics g, int cellSize) {
        g.setColor(Color.red);
        for (int i = 0; i <= levelHandler.getWidth(); i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, levelHandler.getHeight() * cellSize);
            if (i <= levelHandler.getWidth())
                g.drawLine(0, i * cellSize, levelHandler.getWidth() * cellSize, i * cellSize);
        }
    }

    private String formatTime(long millis) {
        long seconds = (millis / 1000) % 60;
        long minutes = (millis / (1000 * 60)) % 60;
        return String.format("%02d:%02d", minutes, seconds);
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
        repaint();
    }

}
