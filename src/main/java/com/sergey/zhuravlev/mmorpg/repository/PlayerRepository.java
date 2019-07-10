package com.sergey.zhuravlev.mmorpg.repository;

import com.sergey.zhuravlev.mmorpg.domain.Player;
import org.springframework.data.repository.Repository;

public interface PlayerRepository extends Repository<Player, Long> {

    Player save(Player player);

    Player getById(Long id);

    void delete(Player player);

}
