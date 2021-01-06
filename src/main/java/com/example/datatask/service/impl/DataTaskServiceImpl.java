package com.example.datatask.service.impl;

import com.example.datatask.service.DataTaskService;
import com.example.datatask.task.DataTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author Jjn
 * @since 2021-01-06 16:21
 */
@Service
@Slf4j
public class DataTaskServiceImpl implements DataTaskService {

    private static final ExecutorService DATA_TASK_EXECUTOR = Executors.newFixedThreadPool(4);

    @Override
    public Long addNewTask(int count) {
        Long resultData = 0L;
        DataTask dataTask = new DataTask(resultData, count);
        Future<Long> submittedTask = DATA_TASK_EXECUTOR.submit(dataTask);
        try {
            submittedTask.get(3, TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException | InterruptedException e) {
            boolean cancel = submittedTask.cancel(true);
            log.info("cancel status:{}", cancel);
            log.error("{}", e.toString());
        }
        return dataTask.getCount();
    }
}
