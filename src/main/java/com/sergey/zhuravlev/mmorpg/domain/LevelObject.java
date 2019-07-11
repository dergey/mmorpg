package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.enums.LevelObjectType;

public interface LevelObject {

    Integer getX();
    Integer getY();
    Integer getWidth();
    Integer getHeight();
    LevelObjectType getObjectType();
    boolean isPermeable();
    Sprite getSprite();

}
