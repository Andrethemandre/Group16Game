package org.group16.View;

import java.awt.Color;
import java.awt.Graphics;

import org.group16.Controller.PlayerController;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.Level;
import org.group16.Model.Observers.GameObserver;

public class LevelPanel extends GamePanel implements GameObserver{
    private Level currentLevel;
    public LevelPanel(int x, int y, Level level) {
        super(x, y);
        this.currentLevel = level;
    }
    public Player getPlayer(){
        return currentLevel.getPlayer();
    }
    @Override
    public void render(Graphics g) {
		// render the grid
		int cellSize = 32; // hard coded
		g.setColor(new Color(0, 0.5f, 0, 0.75f));
		for (int i = 0; i <= currentLevel.WIDTH; i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, currentLevel.HEIGHT * cellSize);
			if (i <= currentLevel.WIDTH)
				g.drawLine(0, i * cellSize, currentLevel.WIDTH * cellSize, i * cellSize);
        }
    }

    /** This method is called each time the panel updates/refreshes/repaints itself */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		// paint the grid
		int cellSize = 32; // hard coded
		g.setColor(Color.red);
		for (int i = 0; i <= currentLevel.WIDTH; i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, currentLevel.HEIGHT * cellSize);
			if (i <= currentLevel.WIDTH)
				g.drawLine(0, i * cellSize, currentLevel.WIDTH * cellSize, i * cellSize);
        }

        // paint the player
        g.setColor(Color.blue);
        Player currentPlayer = currentLevel.getPlayer();
        int playerX = (int) (2 * cellSize);
        int playerY = (int) (2 * cellSize);
        g.fillRect(playerX+2, playerY+2, playerX-4, playerY-4);

        // paint the enemies

        // paint the blocks
    }

    @Override
    public void updateObserver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateObserver'");
    }
    
}
