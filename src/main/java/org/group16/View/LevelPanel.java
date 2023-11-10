package org.group16.View;

import java.awt.Color;
import java.awt.Graphics;

import org.group16.Model.Level.Level;

public class LevelPanel extends GamePanel{
    private Level currentLevel;
    public LevelPanel(int x, int y, Level level) {
        super(x, y);
        this.currentLevel = level;
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
    
}
