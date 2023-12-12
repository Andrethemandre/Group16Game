package org.group16.View.Panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import org.group16.Model.GameObjects.Enemy.EnemyWithTarget;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Blocks.ITeleportBlock;
import org.group16.Model.GameObjects.Enemy.IEnemy;
import org.group16.Model.GameObjects.Enemy.ITrap;
import org.group16.Model.GameObjects.Goal.IGoal;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.PowerUp.IPowerUp;
import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.Model.Utility.Settings;
import org.group16.View.ViewUtility;

public class LevelPanel extends GamePanel implements GameObserver {
    private LevelHandler levelHandler;
    private JButton pauseButton;

    // Hud
    private BufferedImage redHeartImage;
    private BufferedImage grayHeartImage;
    private BufferedImage pauseImage;
    private BufferedImage backgroundImage;

    // Sprites
    private BufferedImage spearPowerUpImage;
    private BufferedImage spearPowerUpThrowRightImage;
    private BufferedImage spearPowerUpThrowLeftImage;

    private BufferedImage freezePowerUpImage;

    private BufferedImage playerImageRight;
    private BufferedImage playerImageLeft;

    private BufferedImage stationaryBlockImage;
    private BufferedImage movingBlockImage;

    private BufferedImage teleportInactiveImage;
    private BufferedImage teleportActiveImage;

    private BufferedImage basicEnemyImage;
    private BufferedImage basicEnemyRightImage;

    private BufferedImage flyingEnemyWingUpImage;
    private BufferedImage flyingEnemyWingMiddleImage;
    private BufferedImage flyingEnemyWingDownImage;
    private BufferedImage flyingEnemyRightWingUpImage;
    private BufferedImage flyingEnemyRightWingMiddleImage;
    private BufferedImage flyingEnemyRightWingDownImage;

    private BufferedImage spikeImage;

    private BufferedImage goalImage;

    private int flyingEnemyFrame;
    private long currentTime;
    private long lastUpdateTime = 0;

    public LevelPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;

        flyingEnemyFrame = 1;
        pauseButton = ViewUtility.createButton("", new Dimension(40, 40));
        initImages();

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

    private void updateFlyingEnemySprite(){
        flyingEnemyFrame += 1;

        if (flyingEnemyFrame >3){
            flyingEnemyFrame = 1;
        }    
    }

    private void initImages(){
         try {
            // Hud
            redHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/red_heart.png"));
            grayHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/gray_heart.png"));
            pauseImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/pause_menu_icon.png"));
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/background.png"));

            // Sprites
            spearPowerUpImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/spear_power_up.png"));
            spearPowerUpThrowRightImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/spear_throw.png"));
            spearPowerUpThrowLeftImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/spear_throw_left.png"));

            freezePowerUpImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/freeze_power_up.png"));

            playerImageRight = ImageIO.read(getClass().getResourceAsStream("/images/sprites/king_blob.png"));
            playerImageLeft = ImageIO.read(getClass().getResourceAsStream("/images/sprites/king_blob_left.png"));

            basicEnemyImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/basic_enemy.png"));
            basicEnemyRightImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/basic_enemy_right.png"));

            flyingEnemyWingUpImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_wing_up.png"));
            flyingEnemyWingMiddleImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_wing_middle.png"));
            flyingEnemyWingDownImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_wing_down.png"));

            flyingEnemyRightWingUpImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_right_wing_up.png"));
            flyingEnemyRightWingMiddleImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_right_wing_middle.png"));
            flyingEnemyRightWingDownImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/flying_enemy_right_wing_down.png"));

            spikeImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/spike.png"));

            stationaryBlockImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/block.png"));
            movingBlockImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/moving_block.png"));

            teleportActiveImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/teleport_active.png"));
            teleportInactiveImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/teleport_inactive.png"));

            goalImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/goal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        drawBackground(g);

        int cellSize = Settings.TILE_SIZE; 

        IPlayer currentPlayer = levelHandler.getPlayer();

        // GameObjects are painted
        paintPlayer(g, currentPlayer);
        paintEnemies(g);
        paintEnemiesWithTarget(g);
        paintTraps(g);
        paintBlocks(g);
        paintTeleportBlocks(g);
        paintGoal(g);
        paintPowerUps(g);

        // Gameplay hud
        paintHealthBar(g, cellSize, currentPlayer);
        paintStats(g, currentPlayer);
        paintPowerUpIcon(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this);
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

    private void paintPowerUpIcon(Graphics g){
        GameObjectType currentPowerUp = levelHandler.getPlayersPowerUp();
        int centerX = this.getWidth() / 2; // Get the center of the panel
        int rectWidth = 32;

        int rectX = centerX - rectWidth / 2;
        int stringX = centerX - g.getFontMetrics().stringWidth("Powerup") / 2; 
        int stringY = 20; 
    
        g.drawString("Powerup", stringX, stringY);
        g.drawRect(rectX, stringY + 8, rectWidth, rectWidth);
    
        int imageX = rectX + rectWidth / 2 - 8; // Adjust the x-coordinate of the image
        int imageY = 24 + rectWidth / 2 - 8; // Adjust the y-coordinate of the image
    
        switch (currentPowerUp) {
            case SPEAR_____:
                g.drawImage(spearPowerUpImage, imageX, imageY, this); // Draw the image at the adjusted coordinates
                break;
            case FREEZE____:
                g.drawImage(freezePowerUpImage, imageX, imageY, this); // Draw the image at the adjusted coordinates
                break;
            case NOTHING___:
                break;
            default:
                break;
        }
    }

    private String formatTime(long millis) {
        long seconds = (millis / 1000) % 60;
        long minutes = (millis / (1000 * 60)) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void paintStats(Graphics g, IPlayer currentPlayer) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fm = g.getFontMetrics();

        int padding = 10;
        int lineSpacing = 15; // Space between lines of text

        int attemptsX = 155;
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

        drawTwoStringSCentered(g, levelText, formattedElapsedTimeText, levelX, statsY, lineSpacing);
    }

    private void paintPlayer(Graphics g, IPlayer currentPlayer) {
        g.setColor(Color.blue);
        int playerX = currentPlayer.getX();
        int playerY = currentPlayer.getY();
        int playerWidth = currentPlayer.getWidth();
        int playerHeight = currentPlayer.getHeight();
        BufferedImage playerImage;

        switch (currentPlayer.getDirection()) {
            case RIGHT:
                playerImage = playerImageRight;
                g.drawImage(playerImage, playerX, playerY, playerWidth, playerHeight, this);
                break;
            case LEFT:
                playerImage = playerImageLeft;
                g.drawImage(playerImage, playerX, playerY, playerWidth, playerHeight, this);
                break;
            default:
                g.setColor(Color.blue);
                g.fillRect(playerX, playerY, playerWidth, playerHeight);
                break;
        }
    }

    private void paintEnemies(Graphics g) {
        Collection<IEnemy> currentEnemies = levelHandler.getEnemies();
        for (IEnemy enemy : currentEnemies) {
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            BufferedImage enemyImage;

            switch (enemy.getType()) {
                case BASIC_____:
                    enemyImage = getBasicEnemyImage(enemy);
                    g.drawImage(enemyImage, enemyX, enemyY, enemyWidth, enemyHeight, this);
                    break;

                case FLYING____:
                    enemyImage = getFlyingEnemyImage(enemy);
                    g.drawImage(enemyImage, enemyX, enemyY, enemyWidth, enemyHeight, this);
                    break;
                case TELEPORT__:
                    // empty to now draw the teleport rush enemy twice.
                    break;
                default:
                    g.setColor(Color.black);
                    g.fillRect(enemyX, enemyY, enemyWidth, enemyHeight);
                    break;
            }
        }
    }

    private BufferedImage getBasicEnemyImage(IEnemy enemy) {
        BufferedImage enemyImage;
        switch (enemy.getDirection()) {
            case RIGHT:
                enemyImage = basicEnemyRightImage;
                break;
            case LEFT:
                enemyImage = basicEnemyImage;
                break;
            default:
                enemyImage = basicEnemyImage;
                break;      
        }
        return enemyImage;
    }

    private BufferedImage getFlyingEnemyImage(IEnemy enemy) {
        switch (flyingEnemyFrame) {
            case 1:
                switch (enemy.getDirection()) {
                    case RIGHT:
                        return flyingEnemyRightWingUpImage;
                    case LEFT:
                        return flyingEnemyWingUpImage;
                    default:
                        return flyingEnemyWingUpImage;
                }
            case 2:
                switch (enemy.getDirection()) {
                    case RIGHT:
                        return flyingEnemyRightWingMiddleImage;
                    case LEFT:
                        return flyingEnemyWingMiddleImage;
                    default:
                        return flyingEnemyWingMiddleImage;
                }
            case 3:
                switch (enemy.getDirection()) {
                    case RIGHT:
                        return flyingEnemyRightWingDownImage;
                    case LEFT:
                        return flyingEnemyWingDownImage;
                    default:
                        return flyingEnemyWingDownImage;
                }
            default:
                return flyingEnemyWingUpImage;
        }
    }

    private void paintEnemiesWithTarget(Graphics g) {
        Collection<EnemyWithTarget> currentEnemiesWithTarget = levelHandler.getEnemiesWithTarget();
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
                return new Color(0, 0, 255);
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
            BufferedImage trapImage;

            switch (trap.getType()) {
                case SPIKE_____:
                    trapImage = spikeImage;
                    g.drawImage(trapImage, trapX, trapY, trapWidth, trapHeight, this);
                    break;
                default:
                    g.setColor(Color.black);
                    g.fillRect(trapX, trapY, trapWidth, trapHeight);
            }
        }
    }

    private void paintBlocks(Graphics g) {
        Collection<IBlock> currentBlocks = levelHandler.getBlocks();
        for (IBlock block : currentBlocks) {
            int blockX = block.getX();
            int blockY = block.getY();
            int blockWidth = block.getWidth();
            int blockHeight = block.getHeight();
            BufferedImage blockImage;

            switch (block.getType()) {
                case STATIONARY:
                    blockImage = stationaryBlockImage;
                    g.drawImage(blockImage, blockX, blockY, blockWidth, blockHeight, this);
                    break;
                case MOVABLE___:
                    blockImage = movingBlockImage;
                    g.drawImage(blockImage, blockX, blockY, blockWidth, blockHeight, this);
                    break;
                case TELEPORTER:
                    // Empty to not draw the teleport block twice.
                    break;
                default:
                    g.setColor(Color.ORANGE);
                    g.fillRect(blockX, blockY, blockWidth, blockHeight);
            }
        }
    }

    private void paintTeleportBlocks(Graphics g) {
        Collection<ITeleportBlock> teleportBlocks = levelHandler.getTeleportBlocks();

        for (ITeleportBlock teleportBlock : teleportBlocks) {
            int blockX = teleportBlock.getX();
            int blockY = teleportBlock.getY();
            int blockWidth = teleportBlock.getWidth();
            int blockHeight = teleportBlock.getHeight();
            BufferedImage teleportBlockImage;

            switch (teleportBlock.getType()) {
                case TELEPORTER:
                    teleportBlockImage = getTeleportBlockImage(teleportBlock);
                    g.drawImage(teleportBlockImage, blockX, blockY, blockWidth, blockHeight, this);
                    break;
                default:
                    g.setColor(Color.GRAY);
                    g.fillRect(blockX, blockY, blockWidth, blockHeight);
                    break;
            }
        }
    }

    private BufferedImage getTeleportBlockImage(ITeleportBlock teleportBlock) {
        if (teleportBlock.isActive()) {
            return teleportActiveImage;
        } else {
            return teleportInactiveImage;
        }
    }

    private void paintGoal(Graphics g) {
        IGoal Goal = levelHandler.getGoal();
        int GoalX = Goal.getX();
        int GoalY = Goal.getY();
        int GoalWidth = Goal.getWidth();
        int GoalHeight = Goal.getHeight();
        g.drawImage(goalImage, GoalX, GoalY, GoalWidth, GoalHeight, this);
    }

    private void paintPowerUps(Graphics g) {
        Collection<IPowerUp> currentPowerUps = levelHandler.getPowerUps();
        for (IPowerUp powerUp : currentPowerUps) {
            int powerUpX = powerUp.getX();
            int powerUpY = powerUp.getY();
            int powerUpWidth = powerUp.getWidth();
            int powerUpHeight = powerUp.getHeight();
            BufferedImage powerUpImage;

            switch (powerUp.getType()) {
                case SPEAR_____:
                    powerUpImage = getSpearPowerUpImage(powerUp);
                    g.drawImage(powerUpImage, powerUpX, powerUpY, powerUpWidth, powerUpHeight, this);
                    break;
                case FREEZE____:
                    powerUpImage = freezePowerUpImage;
                    g.drawImage(powerUpImage, powerUpX, powerUpY, powerUpWidth, powerUpHeight, this);
                    break;
                default:
                    g.setColor(Color.CYAN);
                    g.fillRect(powerUpX, powerUpY, powerUpWidth, powerUpHeight);
            }
        }
    }

    private BufferedImage getSpearPowerUpImage(IPowerUp powerUp) {
        switch (powerUp.getDirection()) {
            case RIGHT:
                return spearPowerUpThrowRightImage;
            case LEFT:
                return spearPowerUpThrowLeftImage;
            default:
                return spearPowerUpImage;
        }
    }

    @Override
    public void updateObserver() {
        if (levelHandler.getGameState() == GameState.PLAYING) {
            currentTime = levelHandler.getElapsedTime();
            if(currentTime == 0){
                lastUpdateTime = 0;
            }
            
            if (currentTime - lastUpdateTime >= 1000) {
                lastUpdateTime = currentTime;
                updateFlyingEnemySprite();
                repaint();
            }
            
            pauseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } 
        else {
            pauseButton.setCursor(Cursor.getDefaultCursor());
        }
    }
}