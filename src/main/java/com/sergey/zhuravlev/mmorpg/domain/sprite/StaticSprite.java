package com.sergey.zhuravlev.mmorpg.domain.sprite;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StaticSprite extends Sprite {

    public StaticSprite(int x, int y, String path) {
        super(SpriteType.STATIC, x, y, path);
    }

    public StaticSprite(int x, int y, int width, int height, String path) {
        super(SpriteType.STATIC, x, y, width, height, path);
    }

}
