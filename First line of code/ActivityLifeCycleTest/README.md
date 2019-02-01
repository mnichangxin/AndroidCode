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

1. 利用 `Bundle` 保存数据

``` java
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }
```

2. 利用 `Bundle` 恢复数据

``` java
    if (savedInstanceState != null) {
        String tempData = savedInstanceState.getString("data_key");
        Log.d("MainActivity", tempData);
    }
```

## 活动的启动模式

1. standard

默认的启动模式，每次启动一个活动都要创建一个实例

2. singleTop

每次启动一个活动，首先检查栈顶是否存在，不存在重新创建一个实例

3. singleTask

每次启动一个活动，检查全栈中是否存在，不存在重新创建一个实例

4. singleInstance

创建两个返回栈，可用于共享实例

