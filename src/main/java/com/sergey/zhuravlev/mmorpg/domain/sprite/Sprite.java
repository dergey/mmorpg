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

    public static int DEFAULT_SPRITE_WIDTH = 32;
    public static int DEFAULT_SPRITE_HEIGHT = 32;

    protected SpriteType type;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String path;

    public Sprite(SpriteType type, int x, int y, String path) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = DEFAULT_SPRITE_WIDTH;
        this.height = DEFAULT_SPRITE_HEIGHT;
        this.path = path;
    }

}
