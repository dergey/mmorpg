package com.sergey.zhuravlev.mmorpg.utils;

import com.sergey.zhuravlev.mmorpg.domain.*;
import com.sergey.zhuravlev.mmorpg.domain.sprite.StaticSprite;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LevelFactoryImpl implements LevelFactory {

    private final String title;
    private final boolean startLevel;
    private final Integer width;
    private final Integer height;
    private final Integer spawnPointX;
    private final Integer spawnPointY;

    public LevelFactoryImpl() {
        title = "start_world";
        startLevel = true;
        width = 500;
        height = 500;
        spawnPointX = 240;
        spawnPointY = 240;
    }

    public Level createLevel() {
        StaticSprite levelBaseSprite = new StaticSprite(0, 0, "sprite/background/mood.png");
        Level level = new Level(title, startLevel, spawnPointX, spawnPointY, width, height, levelBaseSprite, new ArrayList<>());
        Building spawn = createSpawn(5, 5);
        level.getObjects().add(spawn);
        return level;
    }

    private Building createSpawn(int levelX, int levelY) {
        StaticSprite spawnSprite = new StaticSprite(576, 448, "sprite/base_out_atlas.png");
        Building spawn = new Building(levelX, levelY, Level.LEVEL_POINT_WIDTH, Level.LEVEL_POINT_HEIGHT, true, spawnSprite);
        return spawn;
    }

}
