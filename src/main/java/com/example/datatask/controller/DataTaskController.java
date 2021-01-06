package com.example.datatask.controller;

import com.example.datatask.service.DataTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jjn
 * @since 2021-01-06 16:18
 */
@RestController
@CrossOrigin
@Slf4j
public class DataTaskController {

    @Resource
    private DataTaskService dataTaskService;

    @GetMapping(value = "/test")
    public Long dataApi(@RequestParam("count") int count) {
        log.info("count:{}", count);
        Long list = dataTaskService.addNewTask(count);
        log.info("Response: {}", list);
        return list;
    }
}
