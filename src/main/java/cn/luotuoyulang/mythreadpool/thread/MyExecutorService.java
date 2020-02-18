package cn.luotuoyulang.mythreadpool.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutorService {

    /**
     * 一直在保持运行的线程数
     */
    private List<WorkThread> workTreads;

    /**
     * 执行我们的任务队列容器
     */
    private BlockingQueue<Runnable> taskRunables;

    private volatile Boolean isWorking = true;

    public MyExecutorService(int workTreads, int taskRunables) {
        this.taskRunables = new LinkedBlockingQueue<Runnable>(taskRunables);
        this.workTreads = new ArrayList<>();
        for (int i = 0; i < workTreads; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            this.workTreads.add(workThread);
        }
    }

    class WorkThread extends Thread{

        @Override
        public void run() {
            while (isWorking || taskRunables.size() > 0){
                Runnable task = taskRunables.poll();
                if(task != null){

                    task.run();
                }
            }
        }
    }

    public boolean execute(Runnable runnable){
        return taskRunables.offer(runnable);
    }

    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(3, 6);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"    " + finalI);
                }
            });
        }
        myExecutorService.shutdown();
    }

    public void shutdown(){
        this.isWorking = false;
    }
}
