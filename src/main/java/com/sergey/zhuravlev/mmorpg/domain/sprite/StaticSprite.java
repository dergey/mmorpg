package com.sergey.zhuravlev.mmorpg.domain.sprite;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StaticSprite extends Sprite {

    public StaticSprite(int x, int y, String path) {
        super(SpriteType.STATIC, x, y, path);
    }
}
