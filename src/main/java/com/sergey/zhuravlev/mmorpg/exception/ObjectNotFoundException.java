package com.sergey.zhuravlev.mmorpg.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Class objectType) {
        super("Object " + objectType.getSimpleName() + " not found!");
    }
}
