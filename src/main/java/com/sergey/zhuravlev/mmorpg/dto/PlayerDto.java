package com.sergey.zhuravlev.mmorpg.dto;

import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    private String name;
    private int level;
    private PlayerType type;
    private int healsPointMax;
    private int healsPoint;
    private int magicPointMax;
    private int magicPoint;
    private int attack;
    private int armor;

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    private Sprite sprite;

}
