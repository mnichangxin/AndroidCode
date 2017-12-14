# 初探 Activity

* 创建 `Activity`:

1. 配置 `AndroidManifest.xml`，默认 `Android Studio` 已创建：

``` xml
    <activity android:name=".FirstActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
```

其中 `<intent-filter>` 将活动设置为主活动

2. 重写 `Activity` 的方法：

``` java
    public class FirstActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.first_layout);

            Button button = (Button) findViewById(R.id.button_1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FirstActivity.this, "You clicked this button", Toast.LENGTH_SHORT).show();
                }
            });
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item) {
            switch (item.getItemId()) {
                case R.id.add_item:
                    Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.remove_item:
                    Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
            return true;
        }
    }
```


* `Layout` 部分：

1. Button:

```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical" android:layout_width="match_parent"
        android:layout_height="match_parent">
        <Button
            android:id="@+id/button_1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Button"
            />
    </LinearLayout>
```

2. Menu:

```xml
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android">
        <item android:id="@+id/add_item"
              android:title="Add" />
        <item android:id="@+id/remove_item"
              android:title="Remove" />
    </menu>
```



