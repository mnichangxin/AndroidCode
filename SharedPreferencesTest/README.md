# Android 数据持久化 —— SharedPreferences

## 获取 SharedPreferences 对象的方法

1. Context 类中的 getSharedPreferences() 方法
2. Activity 类中的 getPreferences() 方法
3. PreferenceManger 类中的 getDefaultSharedPreferences() 方法

## 存储数据

``` java
    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
    editor.putString("name", "Tom");
    editor.putInt("age", 20);
    editor.putBoolean("married", false);
    editor.apply();
```

## 读取数据

``` java
    SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
    String name = pref.getString("name", "");
    int age = pref.getInt("age", 0);
    boolean married = pref.getBoolean("married", false);
```
