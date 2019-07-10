package com.sergey.zhuravlev.mmorpg.dto;

import com.sergey.zhuravlev.mmorpg.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoDto {

    private PlayerDto player;
    private Level level;

}
