package com.sergey.zhuravlev.mmorpg.controller;

import com.sergey.zhuravlev.mmorpg.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

}
