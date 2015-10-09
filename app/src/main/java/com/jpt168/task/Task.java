package com.jpt168.task;

/**
 * Created by caomingyu on 15/9/7.
 * email:361786231@qq.com
 */
public interface Task<Result> extends Runnable {
    public void cancel();
    public static final int MODE_ASYNC = 0;
    public static final int MODE_SERIAL = 1;
    public int taskMode();
    public Result doTask();
    public boolean isCancelled();
}
