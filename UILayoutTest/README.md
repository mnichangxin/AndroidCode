# Android UI -- 基本布局

## 基础属性

* `android:layout_width & android:layout_height`：match_parent | wrap_content

指定宽或高跟随父元素或者适应内容

* `android:layout_margin(Top|Bottom|Left|Right)`：值

指定相对于父组件的边距

* `android:layout_padding(Top|Bottom|Left|Right)`：值

指定内容相对于组件的边距

* layout_gravity: Left | Right | Top | Bottom | Center

指定组件相对于父组件的位置

* gravity: Left | Right | Top | Bottom | Center

指定内容相对于组件的位置

## 帧布局（FrameLayout）

最简单的布局方式，只能应用基础属性

## 线性布局（LinearLayout）

* `android:orientation`：horizontal | vertical

指定线性布局的排列方式（水平排列、垂直排列）

* `android:layout_weight`：分割值

指定线性布局同一方向上所占的比例

## 绝对布局（AbsoluteLayout）

* `android:layout_x & android:layout_y`：值

指定相对于父组件的绝对位置

## 相对布局（RelativeLayout）

* `android:layout_alignParent(Left|Right|Top|Bottom) & android:layout_(centerHorizontal|layout_centerVertical|layout_centerInParent )`：true | false

指定组件在父元素中的位置（上下左右）

* `android:layout_(above|below|toLeftOf|toRightOf)`：相对于的组件的ID

指定当前组件位于给定组件的位置（上下左右）

* `android:layout_align(Top|Bottom|Left|Right|Baseline)`：相对于组件的ID

指定当前组件与给定组件的（上下左右）边重合

## 百分比布局（PercentFrameLayout | PercentRelativeLayout）

新增布局方式，目前需要引包

* `app:layout_widthPercent | app:layout_heightPercent`：百分比

指定相对于父元素的百分比




