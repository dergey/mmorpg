package com.sergey.zhuravlev.mmorpg.domain.sprite;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AnimatedSprite.class, name = "ANIMATION"),
        @JsonSubTypes.Type(value = StaticSprite.class, name = "STATIC")
})
public abstract class Sprite {

    public enum SpriteType {

        ANIMATION,
        STATIC

    }

    protected SpriteType type;
    protected int x;
    protected int y;
    protected static int SPRITE_WIDTH = 32;
    protected static int SPRITE_HEIGHT = 32;
    protected String path;

    public int getSpriteWidth() {
        return SPRITE_WIDTH;
    }

    public int getSpriteHeight() {
        return SPRITE_WIDTH;
    }
}
