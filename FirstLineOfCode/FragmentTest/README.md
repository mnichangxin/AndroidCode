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

## 屏幕适配

### 屏幕特征：

* small：提供给小屏幕设备的资源
* normal：提供给中等屏幕设备的资源
* large：提供给大屏幕设备的资源
* xlarge：提供给超大屏幕设备的资源

### 分辨率

* ldpi：提供给低分辨率设备的资源（120dpi以下）
* mdpi：提供给中等分辨率设备的资源（120dpi~160dpi）
* hdpi：提供给高分辨率设备的资源（160dpi~240dpi）
* xhdpi：提供给超高分辨率设备的资源（240dpi~320dpi）
* xxhdpi：提供给超超高分辨率设备的资源（320dip~480dpi）

### 方向

* land：提供给横屏设备的资源
* port：提供给竖屏设备的资源

### 最小限定符

`sw` + `dp` 单位像素
