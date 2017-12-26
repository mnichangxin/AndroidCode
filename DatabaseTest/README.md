# Android 数据持久化 —— SQLite 数据库
       
1. 创建数据库

`SQLiteOpenHelpr` 是一个抽象类，需要创建一个帮助类去继承它。

* 抽象方法： `onCreate()` 和 `onUpgrade()` ，必须在帮助类里重写这两个方法，从而实现床架你数据库的逻辑
* 实例方法：`getReadableDatabase()` 和 `getWriteableDatabase()` ，只读和只写
* 构造方法：接收四个参数 Context, DatabaseName, Cursor, Version

2. 添加数据

insert()，传入三个参数：表名称、NULL、ContentValues 对象

3. 更新数据

update()，传入四个参数：表名称、ContentValues 对象、约束更新某一行或几行的数据

4. 删除数据

delete()，传入三个参数：表名称、约束删除某一行或几行的数据

5. 查询数据

query()