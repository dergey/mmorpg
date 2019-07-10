package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.StaticSprite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Level {

    public static int LEVEL_POINT_WIDTH = 32;

    public static int LEVEL_POINT_HEIGHT = 32;

    private String title;

    private boolean startLevel;

    private int spawnPointX;

    private int spawnPointY;

    private int width;

    private int height;

    private StaticSprite baseSprite;

    private Collection<LevelObject> objects;

    public int getLevelPointHeight() {
        return LEVEL_POINT_HEIGHT;
    }

    public int getLevelPointWidth() {
        return LEVEL_POINT_WIDTH;
    }

}
