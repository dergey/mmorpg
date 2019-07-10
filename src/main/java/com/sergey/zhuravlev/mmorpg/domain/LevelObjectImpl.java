package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class LevelObjectImpl implements LevelObject {

    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;
    protected boolean permeable;

    private Sprite sprite;

    public abstract void action(Event event);

}
