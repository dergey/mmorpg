package com.sergey.zhuravlev.mmorpg.service;

import com.sergey.zhuravlev.mmorpg.domain.Level;
import com.sergey.zhuravlev.mmorpg.repository.LevelRepository;
import com.sergey.zhuravlev.mmorpg.utils.LevelFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class WorldService {

    private final LevelFactory levelFactory;
    private final LevelRepository levelRepository;

    @PostConstruct
    private void initWorld() {
        Level level = levelFactory.createLevel();
        levelRepository.save(level);
    }

}
