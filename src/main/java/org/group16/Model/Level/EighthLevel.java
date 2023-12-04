package org.group16.Model.Level;

import java.util.Queue;

import org.group16.Model.GameObjects.GameObjectType;

public class EighthLevel extends Level {
    private static final GameObjectType[][] levelLayout = {{}};

    public EighthLevel(int levelNumber) {
        super(levelLayout, levelNumber);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Queue<Metadata> createMetadata() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMetadata'");
    }
    
}
