package com.sergey.zhuravlev.mmorpg.domain.sprite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimatedSprite extends Sprite {

    private int endX;
    private int endY;
    private int timing;

    public AnimatedSprite(int x, int y, int endX, int endY, int timing, String path) {
        super(SpriteType.ANIMATION, x, y, path);
        this.endX = endX;
        this.endY = endY;
        this.timing = timing;
    }

}
