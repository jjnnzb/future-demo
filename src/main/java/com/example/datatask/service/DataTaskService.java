package com.example.datatask.service;

/**
 * @author Jjn
 * @since 2021-01-06 16:20
 */
public interface DataTaskService {
    /**
     * Add new task.
     *
     * @param count count
     * @return total consumed time in millis
     */
    Long addNewTask(int count);
}
