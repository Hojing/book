package cn.liguohao.review.concurrent;

import org.junit.Test;

import java.util.concurrent.*;


/**
 * Java中线程创建(实现)方式
 *  总结：
 *
 */
public class CreateConcurrentThread  {

    @Test //继承Thred类
    public void extendsThread(){
        new MyThread().run(); //MyThread	running ...
    }
    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(MyThread.class.getSimpleName()+"\trunning ...");
        }
    }

    @Test //实现runnable接口
    public void implementsRunnable(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("mehtod implementsRunnable running ...");
//            }
//        }).run();
        // lambda 表达式，功能和上方一样，代码更优雅。
        new Thread(()->System.out.println("mehtod implementsRunnable running ...")).run();
    }


    @Test //实现Callable接口，有返回值 ，需要借助线程池
    public void implementCallable() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<Object> future = pool.submit(new MyCallable()); //MyCallable running ...
        System.out.println(future.get().toString()); //MyCallable running success
        pool.shutdown();
    }
    class MyCallable implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println("MyCallable running ...");
            return "MyCallable running success";
        }
    }

    @Test //向线程池ExecutorService的execute方法中传入Runable实现类
    public void threadPoolCreateThread(){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //传入Runable接口实现类
        pool.execute(()->System.out.println(Thread.currentThread().getName() +" method threadPoolCreateThread"+ " is running .."));
        //pool-1-thread-1 method threadPoolCreateThread is running .
        pool.shutdown();
    }



}
