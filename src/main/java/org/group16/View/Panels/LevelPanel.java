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

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Enemy.IEnemy;
import org.group16.Model.GameObjects.Enemy.ITrap;
import org.group16.Model.GameObjects.Goal.IGoal;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.PowerUp.IPowerUp;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.ViewUtility;

public class LevelPanel extends GamePanel implements GameObserver {
    private LevelHandler levelHandler;
    private BufferedImage redHeartImage;
    private BufferedImage grayHeartImage;
    private BufferedImage levelClockImage;
    private BufferedImage pauseImage;
    
    private JButton pauseButton;

    //sprites
    private BufferedImage spearPowerUpImage;
    private BufferedImage spearPowerUpThrowRightImage;
    private BufferedImage spearPowerUpThrowLeftImage;

    private BufferedImage freezePowerUpImage;

    private BufferedImage playerImage;
    private BufferedImage playerImageLeft;

    private BufferedImage blockImage;
    private BufferedImage movingBlockImage;

    private BufferedImage teleportInactiveImage;
    private BufferedImage teleportActiveImage;

    private BufferedImage basicEnemyImage;
    private BufferedImage basicEnemyRightImage;

    private BufferedImage flyingEnemy1Image;
    private BufferedImage flyingEnemy2Image;
    private BufferedImage flyingEnemy3Image;
    private BufferedImage flyingEnemyRight1Image;
    private BufferedImage flyingEnemyRight2Image;
    private BufferedImage flyingEnemyRight3Image;
    private int flying_enemy_frame;

    private BufferedImage spikeImage;

    private BufferedImage goalImage;

    private BufferedImage backroundImage;


    private Color flyingEnemyColor;
    private Random random;

    public LevelPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
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

        random = new Random();
        flying_enemy_frame = 1;
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
                    flying_enemy_frame +=1;
                    if (flying_enemy_frame >3){
                        flying_enemy_frame = 1;
                    }
                    flyingEnemyColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    // Calling repaint here is bad
                    // repaint();
                }
            }
        });

        colorChangeThread.start();
    }
    private void initImages(){
         try {
            //hud
            redHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/red_heart.png"));
            grayHeartImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/gray_heart.png"));
            levelClockImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/level_clock.png"));
            pauseImage = ImageIO.read(getClass().getResourceAsStream("/images/hud/pause_menu_icon.png"));
            //sprites
            spearPowerUpImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/spear_powerUp.png"));
            spearPowerUpThrowRightImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/spearThrow.png"));
            spearPowerUpThrowLeftImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/spearThrow_left.png"));

            freezePowerUpImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/freeze_powerUp.png"));

            playerImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/king_blob.png"));
            playerImageLeft = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/king_blob_left.png"));

            basicEnemyImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/basic_enemy.png"));
            basicEnemyRightImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/basic_enemy_right.png"));

            flyingEnemy1Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy (1).png"));
            flyingEnemy2Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy (2).png"));
            flyingEnemy3Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy (3).png"));

            flyingEnemyRight1Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy_right(1).png"));
            flyingEnemyRight2Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy_right(2).png"));
            flyingEnemyRight3Image = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/flying_enemy_right(3).png"));

            spikeImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/spike.png"));


            blockImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/Block.png"));
            movingBlockImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/Moving_Block.png"));

            teleportActiveImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/teleport_active.png"));
            teleportInactiveImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/teleport_inactive.png"));

            goalImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/goal.png"));

            backroundImage = ImageIO.read(getClass().getResourceAsStream("/images/Sprites/backround.png"));



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
        int cellSize = 16; // hard coded
        // paintGridWithSize(g, cellSize);

        IPlayer currentPlayer = levelHandler.getPlayer();

        // GameObjects are painted
        g.drawImage(backroundImage, 0, 0, this);
        paintPlayer(g, currentPlayer);
        paintEnemies(g);
        paintTraps(g);
        paintBlocks(g);
        paintGoal(g);
        paintPowerups(g);

        // Gameplay hud
        paintHealthBar(g, cellSize, currentPlayer);
        paintStats(g, currentPlayer);
        paintPowerUpIcon(g);
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
        g.drawString("Powerup", 346,16);
        g.drawRect(352, 24, 32, 32);
        switch (currentPowerUp) {
            case SPEAR_____:
                g.drawImage(spearPowerUpImage, 360,32,this);
                break;
            
            case FREEZE____:
                g.drawImage(freezePowerUpImage, 360,32,this);
 
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
        //g.fillRect(playerX, playerY, currentPlayer.getWidth(), currentPlayer.getHeight());
        if (currentPlayer.getDirection() == Direction.RIGHT){
            g.drawImage(playerImage, playerX, playerY, this);

        }
        else {
            g.drawImage(playerImageLeft, playerX, playerY, this);

        }

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
                if (enemy.getDirection() == Direction.RIGHT){
                    g.drawImage(basicEnemyRightImage, enemyX, enemyY, enemyWidth, enemyHeight, this);
                }
                else{
                g.drawImage(basicEnemyImage, enemyX, enemyY, enemyWidth, enemyHeight, this);
                }
               
                // For flying enemies
            } else if (enemy.getType() == GameObjectType.FLYING____) {
                switch (flying_enemy_frame) {
                    case 1:
                        if (enemy.getDirection() == Direction.RIGHT){
                            g.drawImage(flyingEnemyRight1Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                        else {
                            g.drawImage(flyingEnemy1Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                        break;
                    case 2:
                        if (enemy.getDirection() == Direction.RIGHT){
                            g.drawImage(flyingEnemyRight2Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                        else {
                            g.drawImage(flyingEnemy2Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                        break;
                    case 3 :
                        if (enemy.getDirection() == Direction.RIGHT){
                            g.drawImage(flyingEnemyRight3Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                        else {
                            g.drawImage(flyingEnemy3Image,enemyX,enemyY,enemyWidth,enemyHeight,this);
                        }
                
                    default:
                        break;
                }

            } else if (enemy.getType() == GameObjectType.TELEPORT__) {
                g.setColor(Color.black);
                g.fillOval(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());

                // Default colour and shape
            } else {
                g.setColor(Color.black);
                g.fillRect(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
            }
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
                g.drawImage(spikeImage,trapX,trapY,trapWidth,trapHeight,this);

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
            if (block.getType() == GameObjectType.STATIONARY){
                g.drawImage(blockImage, blockX, blockY,block.getWidth(),block.getHeight(), this);
            }
            else if (block.getType() == GameObjectType.MOVABLE___){
                g.drawImage(movingBlockImage, blockX, blockY, block.getWidth(), block.getHeight(), this);
            }
            else if (block.getType() == GameObjectType.TELEPORTER__) {
                g.drawImage(teleportActiveImage, blockX, blockY, block.getWidth(), block.getHeight(), this);
                
            }
        }
    }

    private void paintGoal(Graphics g) {
        IGoal Goal = levelHandler.getGoal();
        int GoalX = Goal.getX();
        int GoalY = Goal.getY();
        g.drawImage(goalImage, GoalX, GoalY, this);
    }

    private void paintPowerups(Graphics g) {
        Collection<IPowerUp> currentPowerUps = levelHandler.getPowerUps();
        for (IPowerUp powerUp : currentPowerUps) {
            int powerUpX = powerUp.getX();
            int powerUpY = powerUp.getY();

            if (powerUp.getType() == SPEAR_____){
                if (powerUp.isMoving()){
                    if (powerUp.getDirection() == Direction.RIGHT){
                    g.drawImage(spearPowerUpThrowRightImage, powerUpX, powerUpY, this);
                    }
                    else{
                        g.drawImage(spearPowerUpThrowLeftImage, powerUpX, powerUpY, this);
                    }
                }
                else{
                g.drawImage(spearPowerUpImage,powerUpX,powerUpY,this);
                }
            }
            else if (powerUp.getType() == FREEZE____){
                g.drawImage(freezePowerUpImage,powerUpX,powerUpY,this); 
                
            }
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