package com.example.datatask.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Jjn
 * @since 2021-01-06 15:56
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataTask implements Callable<Long> {

    private Long count;

    private Integer maxTime;

    @Override
    public Long call() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int max = Math.max(maxTime, 5);
        for (int i = 0; i < max; i++) {
            count++;
            TimeUnit.MILLISECONDS.sleep(10L);
        }
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("Total consumed time for completing the task: {} ms", totalTimeMillis);
        }
        return totalTimeMillis;
    }
}
