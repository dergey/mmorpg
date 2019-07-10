package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;

public interface LevelObject {

    Integer getX();
    Integer getY();
    Integer getWidth();
    Integer getHeight();
    boolean isPermeable();
    Sprite getSprite();

}
