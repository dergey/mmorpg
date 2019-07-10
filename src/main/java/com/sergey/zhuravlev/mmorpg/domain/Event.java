package com.sergey.zhuravlev.mmorpg.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Event {

    public enum EventType {

        ACTION,
        ATTACK,
        JUMP,
        STAY,
        PASS

    }

    private final EventType type;
    private final LevelObject source;
    private final LevelObject target;

}
