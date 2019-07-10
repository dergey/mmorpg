package com.sergey.zhuravlev.mmorpg.service;

import com.sergey.zhuravlev.mmorpg.domain.Level;
import com.sergey.zhuravlev.mmorpg.exception.ObjectNotFoundException;
import com.sergey.zhuravlev.mmorpg.repository.LevelRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level getLevel(String title) {
        Level level = levelRepository.getByTitle(title);
        if (level == null) {
            throw new ObjectNotFoundException(Level.class);
        }
        return level;
    }

}
