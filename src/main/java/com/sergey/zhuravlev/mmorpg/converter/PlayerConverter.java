package com.sergey.zhuravlev.mmorpg.converter;

import com.sergey.zhuravlev.mmorpg.domain.Player;
import com.sergey.zhuravlev.mmorpg.dto.PlayerDto;

public class PlayerConverter {

    public static PlayerDto getPlayerDto(Player player) {
        return new PlayerDto(
                player.getLevel(),
                player.getType(),
                player.getHealsPointMax(),
                player.getHealsPoint(),
                player.getMagicPointMax(),
                player.getMagicPoint(),
                player.getAttack(),
                player.getArmor(),
                player.getX(),
                player.getY(),
                player.getWidth(),
                player.getHeight(),
                player.getSprite());
    }
}
