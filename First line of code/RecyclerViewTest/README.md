# Android UI —— 滑动组件之 RecyclerView

`Recycle` 属于新增的控件，需要在 `app/build.gradle` 文件中添加依赖项:

```
   compile 'com.android.support:recyclerview-v7:24.2.1'
```

布局文件用法如下：

``` xml
    <android.support.v7.widget.RecyclerView
            android:id="@+id/recycler_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
```

`RecylcerView` 具有自己的适配器 `RecyclerView.Adapter` 

``` java
    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
        private List<Fruit> mFruitList;
    
        static class ViewHolder extends RecyclerView.ViewHolder {
            View fruitView;
            ImageView fruitImage;
            TextView fruitName;
    
            public ViewHolder(View view) {
                super(view);
                fruitView = view;
                fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                fruitName  = (TextView) view.findViewById(R.id.fruit_name);
            }
        }
    
        public FruitAdapter(List<Fruit> fruitList) {
            mFruitList = fruitList;
        }
    
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 纵向滑动
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
    
            // 横向滑动
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_hr, parent, false);
    
            final ViewHolder holder = new ViewHolder(view);
    
            holder.fruitName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Fruit fruit = mFruitList.get(position);
                    Toast.makeText(v.getContext(), "You clicked image" + fruit.getName(), Toast.LENGTH_SHORT).show();
                }
            });
    
            return holder;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Fruit fruit = mFruitList.get(position);
            holder.fruitImage.setImageResource(fruit.getImageId());
            holder.fruitName.setText(fruit.getName());
        }
        @Override
        public int getItemCount() {
            return mFruitList.size();
        }
    }
```

