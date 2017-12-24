# Android 广播接收器 —— Broadcast Receiver

## 静态广播

广播接收器在 AndroidManifest.xml 文件中注册

``` xml
    <receiver
        android:name=".BootCompleteReceiver"
        android:enabled="true"
        android:exported="true">
        <intent-filter>
            <action android:name="android.intent.action.BOOT_COMPLETED" />
        </intent-filter>
    </receiver>
```

## 动态广播

新类继承于 BroadcastReceiver，并重写父类 onReceiver 方法，具体的逻辑在这个方法中执行

``` java
    public class MainLayoutActivity extends AppCompatActivity {
        private IntentFilter intentFilter;
        private NetworkChangeReceiver networkChangeReceiver;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_layout);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            networkChangeReceiver = new NetworkChangeReceiver();
            registerReceiver(networkChangeReceiver, intentFilter);
    
            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                    sendBroadcast(intent, null);
                }
            });
        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
            unregisterReceiver(networkChangeReceiver);
        }
    
        class NetworkChangeReceiver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Network changes", Toast.LENGTH_SHORT).show();
            }
        }
    }
```

## 自定义广播

### 标准广播

完全异步执行的广播，在广播发出之后，所有的广播接收器几乎都在同一时间接收到这条消息，他们之间没有先后顺序

### 有序广播

同步执行的广播，广播发出之后，同一时刻只会有一个广播接收器能够收到这条广播消息


