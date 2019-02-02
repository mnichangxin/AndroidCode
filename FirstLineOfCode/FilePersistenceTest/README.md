# Android 数据持久化 —— 文件

[Java IO 流接口](http://mnichangxin.com/blog/2016/06/05/java-io/)

## 写文件

`Context` 类中提供了一个 `openFileOutput()` 方法，可用于将数据存储到指定的文件中。第一个参数是文件名，第二个参数有两种模式可选：`MODE_PRIVATE` （覆盖）和 `MODE_APPEND` （追加）

``` java
    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

## 读文件

`Context` 类提供的另一个方法 `openFileInput()` ，只有第一个参数

``` java
    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
```
