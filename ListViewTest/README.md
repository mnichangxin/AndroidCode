# Android UI -- 滑动组件之 ListView

`ListView` 的数据需要借助适配器来完成

使用 `ArrayAdapter` 适配器加载视图：

``` java
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainLayoutActivity.this, android.R.layout.simple_expandable_list_item_1, data);
    ListView listView = (ListView) findViewById(R.id.list_view);
    listView.setAdapter(adapter);
```

