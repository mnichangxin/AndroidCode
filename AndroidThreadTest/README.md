# Android 多线程编程

## Java 开启多线程的方法

1. 继承自 Thread 类

``` java
    class MyThread extends Thread {
        public void run() {
            // Task
        }
    }
    MyThread myThread = new MyThread();
    myThread.start();
```

2. 实现 Runnable 接口

非匿名类：

``` java
    class MyThrad implements Runnable {
        public void run() {
            // Task
        }
    }
    MyThread myThread = new MyThread();
    Thread thread = new Thread(myThread);
    thread.start();
```

匿名类：

``` java
    Thread thread = new Thread(new Runnable() {
        public void run() {
            // Task
        }
    });
    thread.start();
```