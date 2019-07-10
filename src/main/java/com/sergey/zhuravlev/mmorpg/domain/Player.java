package com.sergey.zhuravlev.mmorpg.domain;

import com.sergey.zhuravlev.mmorpg.converter.SpriteJpaConverter;
import com.sergey.zhuravlev.mmorpg.domain.sprite.Sprite;
import com.sergey.zhuravlev.mmorpg.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
@Entity
public class Player implements Life, LevelObject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "current_level_title")
    private String currentLevelTitle;

    @Column(name = "level", nullable = false)
    private int level;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PlayerType type;

    @Column(name = "heals_point_max", nullable = false)
    private int healsPointMax;

    @Column(name = "heals_point", nullable = false)
    private int healsPoint;

    @Column(name = "magic_point_max", nullable = false)
    private int magicPointMax;

    @Column(name = "magic_point", nullable = false)
    private int magicPoint;

    @Column(name = "attack", nullable = false)
    private int attack;

    @Column(name = "armor", nullable = false)
    private int armor;

    @Column(name = "x", nullable = false)
    private Integer x;

    @Column(name = "y", nullable = false)
    private Integer y;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "permeable", nullable = false)
    private boolean permeable;

    @Convert(converter = SpriteJpaConverter.class)
    @Column(name = "sprite")
    private Sprite sprite;
}
