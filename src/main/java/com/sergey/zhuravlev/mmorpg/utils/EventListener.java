package com.sergey.zhuravlev.mmorpg.utils;

import com.sergey.zhuravlev.mmorpg.domain.Event;

@FunctionalInterface
public interface EventListener {

    void handle(Event event);

}
