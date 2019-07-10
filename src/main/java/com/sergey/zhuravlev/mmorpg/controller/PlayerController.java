package com.sergey.zhuravlev.mmorpg.controller;

import com.sergey.zhuravlev.mmorpg.converter.PlayerConverter;
import com.sergey.zhuravlev.mmorpg.domain.Level;
import com.sergey.zhuravlev.mmorpg.domain.Player;
import com.sergey.zhuravlev.mmorpg.dto.GameInfoDto;
import com.sergey.zhuravlev.mmorpg.dto.PlayerDto;
import com.sergey.zhuravlev.mmorpg.service.LevelService;
import com.sergey.zhuravlev.mmorpg.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
public class PlayerController {

    private final LevelService levelService;
    private final PlayerService playerService;

    @GetMapping("home")
    private GameInfoDto home() {
        Player player = playerService.getDefaultPlayer();
        Level level = levelService.getLevel(player.getCurrentLevelTitle());
        PlayerDto playerDto = PlayerConverter.getPlayerDto(player);
        return new GameInfoDto(playerDto, level);
    }

}
