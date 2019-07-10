package com.sergey.zhuravlev.mmorpg.converter;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.domain.sprite.StaticSprite;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;

@Converter
public class SpriteJpaConverter implements AttributeConverter<Sprite, String> {

    public static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(Sprite sprite) {
        if (sprite != null) {
            return sprite.getType() + SEPARATOR + sprite.getX() + SEPARATOR + sprite.getY() + SEPARATOR + sprite.getPath();
        } else {
            return null;
        }
    }

    @Override
    public Sprite convertToEntityAttribute(String s) {
        if (s != null) {
            List<String> attributes = Arrays.asList(s.split(SEPARATOR));
            if (Sprite.SpriteType.STATIC.name().equals(attributes.get(0))) {
                return new StaticSprite(Integer.valueOf(attributes.get(1)), Integer.valueOf(attributes.get(2)), attributes.get(3));
            }
            return null;
        } else {
            return null;
        }
    }
}
