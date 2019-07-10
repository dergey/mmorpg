package com.sergey.zhuravlev.mmorpg.service;

import com.sergey.zhuravlev.mmorpg.domain.Level;
import com.sergey.zhuravlev.mmorpg.domain.Player;
import com.sergey.zhuravlev.mmorpg.domain.sprite.StaticSprite;
import com.sergey.zhuravlev.mmorpg.enums.PlayerType;
import com.sergey.zhuravlev.mmorpg.repository.LevelRepository;
import com.sergey.zhuravlev.mmorpg.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@DependsOn(value = "worldService")
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final LevelRepository levelRepository;

    @PostConstruct
    private void initPlayer() {
        Level startLevel = levelRepository.getByStartLevel(true);
        Player player = playerRepository.getById(1L);
        if (player == null) {
            player = new Player(1L,
                    startLevel.getTitle(),
                    1,
                    PlayerType.WARRIOR,
                    100,
                    100,
                    10,
                    10,
                    10,
                    7,
                    startLevel.getSpawnPointX() * Level.LEVEL_POINT_WIDTH,
                    startLevel.getSpawnPointY() * Level.LEVEL_POINT_HEIGHT,
                    32,
                    32,
                    true,
                     new StaticSprite(0, 0, "sprite/player/human_male.png"));
            playerRepository.save(player);
        }
    }

    public Player getDefaultPlayer() {
        return playerRepository.getById(1L);
    }

}

