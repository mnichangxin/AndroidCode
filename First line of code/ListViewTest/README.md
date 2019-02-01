# Android UI -- 滑动组件之 ListView

## ListView 的简单用法

* 视图部分：

定义 `<ListView>` 即可

* 数据部分：

`ListView` 的数据需要借助适配器来完成

比如使用 `ArrayAdapter` 适配器加载数据：

``` java
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainLayoutActivity.this, android.R.layout.simple_expandable_list_item_1, data);
    ListView listView = (ListView) findViewById(R.id.list_view);
    listView.setAdapter(adapter);
```

## 自定义 ListView

* 定义视图模板：

模板为 ListView 的每一项的视图

``` xml
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <ImageView
            android:id="@+id/fruit_image"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
        <TextView
            android:id="@+id/fruit_name"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:gravity="center_vertical"
            android:layout_marginLeft="10dp" />
    </LinearLayout>
```

* 数据加载：

自定义一个适配器

``` java
    class FruitAdapter extends ArrayAdapter<Fruit> {
        private int resourceId;
    
        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }
    
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Fruit fruit = getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
            fruitImage.setImageResource(fruit.getImageId());
            fruitName.setText(fruit.getName());
            return view;
        }
    }
```

像普通适配器一样传入数据

``` java
    FruitAdapter adapter = new FruitAdapter(MainLayoutActivity.this, R.layout.fruit_item, fruitList);
    ListView listView = (ListView) findViewById(R.id.list_view);
    listView.setAdapter(adapter);
```

## 为每一项添加点击事件

``` java
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fruit fruit = fruitList.get(position);
            Toast.makeText(MainLayoutActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
        }
    });
```

## ListView 的性能优化

`Adapter` 的 `getView()` 方法每次都将布局重新加载了一遍，这存在性能的瓶颈。 `getView()` 方法中有一个 `convertView` 参数，将之前加载的布局缓存，以便以后可以进行重用。

``` java
    if (convertView == null) {
        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
    } else {
        view = convertView;
    }
```
