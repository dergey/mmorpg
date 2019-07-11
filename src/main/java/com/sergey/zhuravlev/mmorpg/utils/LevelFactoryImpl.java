package com.sergey.zhuravlev.mmorpg.utils;

import com.sergey.zhuravlev.mmorpg.domain.*;
import com.sergey.zhuravlev.mmorpg.domain.sprite.StaticSprite;
import com.sergey.zhuravlev.mmorpg.enums.LevelObjectType;
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
        spawnPointX = 5;
        spawnPointY = 5;
    }

    public Level createLevel() {
        StaticSprite levelBaseSprite = new StaticSprite(0, 0, "sprite/background/stone.png");
        Level level = new Level(title, startLevel, spawnPointX, spawnPointY, width, height, levelBaseSprite, new ArrayList<>());
        LevelObject spawn = createSpawn(spawnPointX, spawnPointY);
        level.getObjects().add(spawn);
        return level;
    }

    private LevelObject createSpawn(int levelX, int levelY) {
        StaticSprite spawnSprite = new StaticSprite(32, 1632, 32, 64, "sprite/vx_global_4.png");
        LevelObjectImpl spawn = new LevelObjectImpl(
                levelX * Level.LEVEL_POINT_WIDTH,
                levelY * Level.LEVEL_POINT_HEIGHT,
                32,
                64,
                LevelObjectType.BACKGROUND,
                true,
                spawnSprite);
        return spawn;
    }

}
