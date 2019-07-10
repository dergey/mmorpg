package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.utils.EventListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

public class Building extends LevelObjectImpl {

    private final Collection<EventListener> listeners;
    @Getter
    private int levelX;
    @Getter
    private int levelY;

    public void action(Event event) {
        for (EventListener listener : listeners) {
            listener.handle(event);
        }
    }

    public Building(Integer levelX, Integer levelY, Integer width, Integer height, boolean permeable, Sprite sprite) {
        super(0, 0, width, height, permeable, sprite);
        listeners = new ArrayList<>();
        this.levelX = levelX;
        this.levelY = levelY;
    }

    @Override
    public Integer getX() {
        return levelX * Level.LEVEL_POINT_WIDTH;
    }

    @Override
    public Integer getY() {
        return levelY * Level.LEVEL_POINT_HEIGHT;
    }

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

}
