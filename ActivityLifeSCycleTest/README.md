# Activity 的生命周期

## 生命周期方法

1. onCreate()

活动第一次创建的时候被调用，完成活动的初始化操作

2. onStart()

活动由不可见变为可见时被调用

3. onResume()

活动准备和用户进行交互时被调用，此时活动位于栈顶

4. onPause()

准备去启动或者恢复另一个活动时调用

5. onStop()

活动完全不可见时被调用

6. onDestroy()

活动被销毁前被调用

7. onRestart()

由停止状态变为运行状态之前被调用

![](http://7xr2ek.com1.z0.glb.clouddn.com/image/jpg/ActivityLifeCycle.png)

## 活动被回收了怎么办

