package org.github.tjgykhulj.controller;

import org.github.tjgykhulj.RocksDBService;
import org.github.tjgykhulj.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BasicController {

    @Autowired
    private RocksDBService rocksDBService;

    @GetMapping("/get/{key}")
    public BaseResponse<String> get(@PathVariable String key) {
        return BaseResponse.success(rocksDBService.get(key));
    }

    @PostMapping("/put/{key}")
    public BaseResponse<Boolean> put(@PathVariable String key, @RequestParam String val) {
        return BaseResponse.success(rocksDBService.put(key, val));
    }
}
