package org.group16.View.Panels;

import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

//import org.group16.Model.GameObjects.Enemy.MovableEnemy;
//import org.group16.Model.GameObjects.Enemy.TeleportRushEnemy;

import org.group16.Model.GameObjects.Enemy.*;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Goal.IGoal;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.PowerUp.IPowerUp;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.ViewUtility;

public class LevelPanel extends GamePanel implements GameObserver {
    private final LevelHandler levelHandler;
    private BufferedImage redHeartImage;
    private BufferedImage grayHeartImage;
    private BufferedImage levelClockImage;
    private BufferedImage pauseImage;
    private final JButton pauseButton;

    private int reappearCounter = 0;

    private Color flyingEnemyColor;
    private Random random;

    public LevelPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
        pauseButton = ViewUtility.createButton("", new Dimension(40, 40));

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

        random = new Random();
        flyingEnemyColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        // Thread not good for view in mvc, maybe causing problem with the framerate
        Thread colorChangeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flyingEnemyColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    // Calling repaint here is bad
                    // repaint();
                }
            }
        });

        colorChangeThread.start();
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 16; // hard coded
        // paintGridWithSize(g, cellSize);

        IPlayer currentPlayer = levelHandler.getPlayer();

        // GameObjects are painted
        paintPlayer(g, currentPlayer);
        paintEnemies(g);
        paintEnemiesWithTarget(g);
        paintTraps(g);
        paintBlocks(g);
        paintGoal(g);
        paintPowerups(g);

        // Gameplay hud
        paintHealthBar(g, cellSize, currentPlayer);
        paintStats(g, currentPlayer);
    }

    private void drawTwoStringSCentered(Graphics g, String text, String formattedText, int x, int y, int lineSpacing) {
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int formattedTextWidth = fm.stringWidth(formattedText);
        int formattedTextX = x + (textWidth - formattedTextWidth) / 2;

        g.drawString(text, x, y);
        g.drawString(formattedText, formattedTextX, y + lineSpacing);
    }

    private void paintHealthBar(Graphics g, int cellSize, IPlayer currentPlayer) {
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

    private void paintStats(Graphics g, IPlayer currentPlayer) {
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
        if (levelHandler.getCurrentScore() < 0) {
            formattedScore = String.format("%05d", levelHandler.getCurrentScore());
        } else {
            formattedScore = String.format("%04d", levelHandler.getCurrentScore());
        }

        drawTwoStringSCentered(g, scoreText, formattedScore, scoreX, statsY, lineSpacing);

        // Position the level text next to the right edge of the panel
        int levelX = getWidth() - fm.stringWidth("Level: " + levelHandler.getCurrentLevelNumber()) - padding - 60;

        String levelText = "Level: " + levelHandler.getCurrentLevelNumber();
        String formattedElapsedTimeText = formatTime(levelHandler.getElapsedTime());

        drawTwoStringSCentered(g, levelText, formattedElapsedTimeText, levelX - 55, statsY, lineSpacing);

        g.drawImage(levelClockImage, levelX + fm.stringWidth(levelText) + padding - 55, padding + 3, this);
    }

    private void paintPlayer(Graphics g, IPlayer currentPlayer) {
        g.setColor(Color.blue);
        int playerX = currentPlayer.getX();
        int playerY = currentPlayer.getY();
        g.fillRect(playerX, playerY, currentPlayer.getWidth(), currentPlayer.getHeight());
    }

    private Color getPulsingColor() {
        float pulse = (float) ((Math.sin(System.currentTimeMillis() / 2000.0) + 1) / 2); // Oscillates between 0 and 1
        int red = (int) (Color.BLACK.getRed() * pulse + Color.WHITE.getRed() * (1 - pulse));
        int green = (int) (Color.BLACK.getGreen() * pulse + Color.WHITE.getGreen() * (1 - pulse));
        int blue = (int) (Color.BLACK.getBlue() * pulse + Color.WHITE.getBlue() * (1 - pulse));
        return new Color(red, green, blue);
    }


    private void paintEnemies(Graphics g) {
        Collection<IEnemy> currentEnemies = levelHandler.getEnemies();
        for (IEnemy enemy : currentEnemies) {
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
                // For flying enemies
            } else if (enemy.getType() == GameObjectType.FLYING____){
                g.setColor(flyingEnemyColor);
                g.fillOval(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
            }
        }
    }

    private void paintEnemiesWithTarget(Graphics g) {
        Collection<EnemyWithTarget> currentEnemiesWithTarget = levelHandler.getEnemiesWithTargets();
        for (EnemyWithTarget enemyWithTarget : currentEnemiesWithTarget) {
            int enemyWithTargetX = enemyWithTarget.getX();
            int enemyWithTargetY = enemyWithTarget.getY();
            Color color = getColorBasedOnState(enemyWithTarget);
            g.setColor(color);
            g.fillOval(enemyWithTargetX, enemyWithTargetY, enemyWithTarget.getWidth(), enemyWithTarget.getHeight());
        }
    }

    private Color getColorBasedOnState(EnemyWithTarget enemyWithTarget) {
        switch (enemyWithTarget.getCurrentState()) {
            case IDLE:
                // For idle state, return a color that blinks faster
                float pulse = (float) ((Math.sin(System.currentTimeMillis() / 1000.0 * 2) + 1) / 2); // Oscillates between 0 and 1
                return new Color(pulse, 0, pulse); // Purple color that blinks faster
            case DISAPPEAR:
                // For disappear state, return a transparent color
                return new Color(0, 0, 0, 0);
            case REAPPEAR:
                reappearCounter = Math.min(255, reappearCounter + 5); // Increase counter by 5 each time, up to 255
                return new Color(0, 0, 0, reappearCounter);
            case CHASE:
                // For chase state, return a color that blinks faster
                float fastPulse = (float) ((Math.sin(System.currentTimeMillis() / 300.0 * 2) + 1) / 2); // Oscillates between 0 and 1
                return new Color(fastPulse, 0, 0); // Red color that blinks faster
            default:
                // For other states, return a default color
                return Color.BLACK;
        }
    }


    private void paintTraps(Graphics g) {
        Collection<ITrap> currentTraps = levelHandler.getTraps();

        for (ITrap trap : currentTraps) {
            int trapX = trap.getX();
            int trapY = trap.getY();
            int trapWidth = trap.getWidth();
            int trapHeight = trap.getHeight();

            if (trap.getType() == GameObjectType.SPIKE_____) {
                int[] xPoints = {trapX, trapX + (trapWidth / 2), trapX + trapWidth};
                int[] yPoints = {trapY + trapHeight, trapY, trapY + trapHeight};
                int nPoints = 3;
                g.setColor(Color.darkGray);
                g.fillPolygon(xPoints, yPoints, nPoints);

            } else {
                g.setColor(Color.black);
                g.fillRect(trapX, trapY, trap.getWidth(), trap.getHeight());
            }
        }
    }

    private void paintBlocks(Graphics g) {
        Collection<IBlock> currentBlocks = levelHandler.getBlocks();
        for (IBlock block : currentBlocks) {
            int blockX = block.getX();
            int blockY = block.getY();
            g.setColor(Color.ORANGE);
            g.fillRect(blockX, blockY, block.getWidth(), block.getHeight());
        }
    }

    private void paintGoal(Graphics g) {
        IGoal Goal = levelHandler.getGoal();
        int GoalX = Goal.getX();
        int GoalY = Goal.getY();
        g.setColor(Color.green);
        g.fillRect(GoalX, GoalY, Goal.getWidth(), Goal.getHeight());
    }

    private void paintPowerups(Graphics g) {
        Collection<IPowerUp> currentPowerUps = levelHandler.getPowerUps();
        for (IPowerUp powerUp : currentPowerUps) {
            int powerUpX = powerUp.getX();
            int powerUpY = powerUp.getY();

            if (powerUp.getType() == SPEAR_____) {
                g.setColor(Color.yellow);
            } else if (powerUp.getType() == FREEZE____) {
                g.setColor(Color.CYAN);
            }
            g.fillRect(powerUpX, powerUpY, powerUp.getWidth(), powerUp.getHeight());
        }
    }

    @Override
    public void updateObserver() {
        if (levelHandler.getGameState() == GameState.PLAYING) {
            pauseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            pauseButton.setCursor(Cursor.getDefaultCursor());
        }
    }
}
