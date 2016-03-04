package org.fred.ztest.task;

import java.util.concurrent.*;

/**
 * Created by fred.zhu on 15/10/16.
 */
public class TaskTest {

    public static void main(String[] args) {
        System.out.println("Start ...");

        ExecutorService exec = Executors.newCachedThreadPool();

        testTask(exec, 9); // 任务成功结束后等待计算结果，不需要等到15秒
//        testTask(exec, 5); // 只等待5秒，任务还没结束，所以将任务中止

        exec.shutdown();
        System.out.println("End!");
    }

    public static void testTask(ExecutorService exec, int timeout) {
        MyTask task = new MyTask();
        Future<String> future = exec.submit(task);
        String taskResult = null;
        String failReason = null;
        try {
            // 等待计算结果，最长等待timeout秒，timeout秒后中止任务
            taskResult = future.get();
            System.out.println(taskResult);
        } catch (InterruptedException e) {
            failReason = "主线程在等待计算结果时被中断！";
        } catch (ExecutionException e) {
            failReason = "主线程等待计算结果，但计算抛出异常！";
        }
        System.out.println("taskResult : " + taskResult);
        System.out.println("failReason : " + failReason);
    }
}
