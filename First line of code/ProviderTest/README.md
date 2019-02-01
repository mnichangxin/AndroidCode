# Android 内容提供器 —— Content Provider

##  创建内容提供器的步骤

1. 新的类继承自 ContentProvider
2. 重写抽象方法：

* onCreate()

初始化内容提供器，true 表示创建成功，false 表示创建失败

* query(uri, projection, selection, selectionArgs, orderBy)

![](http://7xr2ek.com1.z0.glb.clouddn.com/image/jpg/provider-query.png)

查询的结果存放在 Cursor 对象中返回

* insert(uri, values)

返回一个 Uri 对象

* update(uri, values, selection, selectionArgs)

返回 int 型数据

* delete(uri, selection, selectionArgs)

返回 int 型数据

* getType(uri)

返回全部数据：

``` java
    vnd.android.cursor.dir/vnd.com.example.databasetest.provider.book
```

返回单条数据：

``` java
    vnd.android.cursor.item/vnd.com.example.databasetest.provider.book
```
