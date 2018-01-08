# Android 网络技术

## 网络请求

1. 开启连接

``` java
    URL uri = new URL("http://www.baidu.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
```

2. 关闭连接

``` java
    connection.disconnect();
```

## 解析 XML 格式数据

### Pull 解析方式

``` java
    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    // 开始解析某个节点
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    // 完成解析某个节点
                    case XmlPullParser.END_TAG:
                        if ("app".equals(nodeName)) {
                            Log.d("MainActivity", "id is " + id);
                            Log.d("MainActivity", "name is " + name);
                            Log.d("MainActivity", "version is " + version);
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

### SAX 解析方式

1. 重写 DefaultHandler 的方法

``` java
    public class ContentHandler extends DefaultHandler {
        private String nodeName;
        private StringBuilder id;
        private StringBuilder name;
        private StringBuilder version;
    
        @Override
        public void startDocument() throws SAXException {
            id = new StringBuilder();
            name = new StringBuilder();
            version = new StringBuilder();
        }
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // 记录当前节点名
            nodeName = localName;
        }
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // 根据当前的节点判断将内容添加到哪一个 StringBuilder 对象中
            if ("id".equals(nodeName)) {
                id.append(ch, start, length);
            } else if ("name".equals(nodeName)) {
                name.append(ch, start, length);
            } else if ("version".equals(nodeName)) {
                version.append(ch, start, length);
            }
        }
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("app".equals(localName)) {
                Log.d("ContentHandler", "id is " + id.toString().trim());
                Log.d("ContentHandler", "name is " + name.toString().trim());
                Log.d("ContentHandler", "version is " + version.toString().trim());
                // 最后将 StringBuilder 清空掉
                id.setLength(0);
                name.setLength(0);
                version.setLength(0);
            }
        }
        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }
    }
```

2. 执行解析 

``` java
    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new com.example.networktest.ContentHandler();
            // 将 ContentHandler 的实例设置到 XMLReader 中
            xmlReader.setContentHandler(handler);
            // 开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

## 解析 JSON 格式数据

### 使用 JSONObject

``` java
    private void parseJSONWithObeject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id  = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("MainActivity", "id is " + id);
                Log.d("MainActivity", "name is " + name);
                Log.d("MainActivity", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```
