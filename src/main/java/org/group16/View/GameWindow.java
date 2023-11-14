package org.group16.View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import org.group16.Model.Level.FirstLevel;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class GameWindow extends JFrame implements GameObserver{
    // Offsets makes it display correctly
    // The y one makes since because it accounts for the
    // top of the window, however I don't know why
    // an X offset would be needed, maybe we
    // did some wrong calculation?
    private static final int WINDOW_OFFSET_X = 16;
    private static final int WINDOW_OFFSET_Y = 40;

    private static final int X = 720 + WINDOW_OFFSET_X;
    private static final int Y = 480 + WINDOW_OFFSET_Y;

    // mainScreen that changes depending on type of panel (for now it is just a screen of a level)
    private GamePanel mainScreen;
    private LevelHandler levelHandler;

    public GameWindow(String windowName, LevelHandler levelHandler){
        this.levelHandler = levelHandler;
        this.mainScreen = new LevelPanel(X, Y, levelHandler);
        initComponents(windowName);
    }

    public GamePanel getMainScreen(){
        return mainScreen;
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {    
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setVisible(true);
        this.add(mainScreen);
        mainScreen.setPreferredSize(getPreferredSize());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void updateObserver() {
        repaint();
    }

}
