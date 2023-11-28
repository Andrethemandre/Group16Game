package org.group16.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.PowerUp;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class LevelPanel extends GamePanel implements GameObserver{
    private LevelHandler levelHandler;
    private BufferedImage redHeartImage;
    private BufferedImage grayHeartImage;
    private BufferedImage levelClockImage;
    private BufferedImage pauseImage;
    private JButton pauseButton;

    public LevelPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
        pauseButton = ViewUtility.createMenuButton("", new Dimension(40, 40));
  
        try {
            redHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/red_heart.png"));
            grayHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/gray_heart.png"));
            levelClockImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/level_clock.png"));
            pauseImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/pause_menu_icon.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        pauseButton.setIcon(new ImageIcon(pauseImage));
        pauseButton.setBorderPainted(false);
        pauseButton.setContentAreaFilled(false);
        pauseButton.setFocusPainted(false);
        pauseButton.setOpaque(false);
        add(pauseButton, JLayeredPane.DEFAULT_LAYER);
    }

    @Override
    public void doLayout() {
        super.doLayout();
        int buttonWidth = 40;
        int buttonHeight = 40;

        pauseButton.setBounds(getWidth() - buttonWidth - 20, 13, buttonWidth, buttonHeight);
    }

    public Player getPlayer() {
        return levelHandler.getPlayer();
    }

    public JButton getPauseButton(){
        return pauseButton;
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 16; // hard coded
        //paintGridWithSize(g, cellSize);
        
        Player currentPlayer = levelHandler.getPlayer();

        // GameObjects are painted
        paintPlayer(g, currentPlayer);
        paintEnemies(g);
        paintBlocks(g);
        paintFlag(g);
        paintPowerups(g);

        // Gameplay hud
        paintHealthBar(g, cellSize, currentPlayer);
        paintStats(g, currentPlayer);
    }

    private void paintPaused(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString("PAUSED", 250, 250);

    }

    private void drawTwoStringSCentered(Graphics g, String text, String formattedText, int x, int y, int lineSpacing) {
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int formattedTextWidth = fm.stringWidth(formattedText);
        int formattedTextX = x + (textWidth - formattedTextWidth) / 2;
    
        g.drawString(text, x, y);
        g.drawString(formattedText, formattedTextX, y + lineSpacing);
    }
  
    private void paintHealthBar(Graphics g, int cellSize, Player currentPlayer) {
        int health = currentPlayer.getHealth();
        int startX = 0;
        int spacing = 50;

        // Loop over the max player health and draw the appropriate heart image
        for (int i = 0; i < 3; i++) {
            if (health > i) {
                g.drawImage(redHeartImage, startX + i * spacing, 10, this);
            } else {
                g.drawImage(grayHeartImage, startX + i * spacing, 10, this);
            }
        }

    }

    private String formatTime(long millis) {
        long seconds = (millis / 1000) % 60;
        long minutes = (millis / (1000 * 60)) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void paintStats(Graphics g, Player currentPlayer) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        FontMetrics fm = g.getFontMetrics();
    
        int padding = 10; 
        int lineSpacing = 15; // Space between lines of text
    
        int attemptsX = 175;
        int statsY = 20 + fm.getAscent(); // fm.getAscent() is needed to align the text properly
    
        String attemptsText = "Attempts";
        String formattedAttempts = String.format("%04d", levelHandler.getCurrentAttempts());
    
        drawTwoStringSCentered(g, attemptsText, formattedAttempts, attemptsX, statsY, lineSpacing);

        // Position the score text after the attempts text
        int scoreX = attemptsX + fm.stringWidth(attemptsText) + padding; 
    
        String scoreText = "Score";
        String formattedScore = "";
        
        // The amount of decimals reduce if score is negative
        if (levelHandler.getScore() < 0) {
            formattedScore = String.format("%05d",levelHandler.getScore());
        } else {
            formattedScore = String.format("%04d", levelHandler.getScore());
        }
    
        drawTwoStringSCentered(g, scoreText, formattedScore, scoreX, statsY, lineSpacing);

        // Position the level text next to the right edge of the panel
        int levelX = getWidth() - fm.stringWidth("Level: " + levelHandler.getCurrentLevelNumber()) - padding - 60; 
    
        String levelText = "Level: " + levelHandler.getCurrentLevelNumber();
        String formattedElapsedTimeText = formatTime(levelHandler.getElapsedTime());
    
        drawTwoStringSCentered(g, levelText, formattedElapsedTimeText, levelX - 55, statsY, lineSpacing);
    
        g.drawImage(levelClockImage, levelX + fm.stringWidth(levelText) + padding - 55, padding+3, this);
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
                g.fillRect(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
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

    private void paintPowerups(Graphics g){
        Collection<PowerUp> currentPowerUps = levelHandler.getPowerUps();
        for (PowerUp powerUp : currentPowerUps){
            int powerUpX = (int) powerUp.getX();
            int powerUpY = (int) powerUp.getY();
            g.setColor(Color.yellow);
            g.fillRect(powerUpX, powerUpY, powerUp.getWidth(),powerUp.getHeight());
        }
    }
    
    @Override
    public void updateObserver() {
        if(levelHandler.getGameState() == GameState.PLAYING){
            pauseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else{
            pauseButton.setCursor(Cursor.getDefaultCursor());
        }
    }
    
}