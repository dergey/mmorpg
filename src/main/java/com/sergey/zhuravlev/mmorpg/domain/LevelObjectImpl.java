package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.enums.LevelObjectType;
import com.sergey.zhuravlev.mmorpg.utils.EventListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelObjectImpl implements LevelObject {

    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;
    protected LevelObjectType objectType;
    protected boolean permeable;

    private Sprite sprite;

    private final Collection<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void action(Event event) {
        for (EventListener listener : listeners) {
            listener.handle(event);
        }
    }

}
