package com.sergey.zhuravlev.mmorpg.repository;

import com.sergey.zhuravlev.mmorpg.domain.Level;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LevelRepository {

    private Map<String, Level> levelStorage;

    public LevelRepository() {
        this.levelStorage = new HashMap<>();
    }

    public Level save(Level level) {
       return levelStorage.put(level.getTitle(), level);
    }

    public Level getByTitle(String title) {
        return levelStorage.get(title);
    }

    public Level getByStartLevel(boolean startLevel) {
        for (Level level : levelStorage.values()) {
            if (level.isStartLevel() == startLevel) {
                return level;
            }
        }
        return null;
    }

}
