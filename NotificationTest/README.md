# Android 消息通知

## 基本用法

* 构造 Notification 对象：

``` java
    Intent intent = new Intent(this, NotificationActivity.class);
    PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
    NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
```

* 构造兼容的 Notification 对象：

``` java
    Notification notification = new NotificationCompat.Builder(this)
```
    
* 设置标题：setContentTitle()

* 设置内容：setContentText()

* 设置时间：setWhen()


