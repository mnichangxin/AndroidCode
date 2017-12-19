# Android UI —— 碎片（Fragment）

## 生命周期

![](http://7xr2ek.com1.z0.glb.clouddn.com/image/jpg/fragment-cycle.jpg)

## 替换碎片

1. 创建待添加的碎片实例
2. 获取 `FragmentManger` ，在活动中可以直接通过 `getSupportFragmentManer()` 方法得到
3. 开启一个事务，通过调用 `beginTransaction` 方法开启
4. 向容器内添加或替换碎片，一般使用 `replace()` 方法实现，须传入容器的 ID 和待添加的碎片实例
5. 提交事务，调用 `commit()` 方法来完成

```
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
```

