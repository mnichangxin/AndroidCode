# Android 运行时权限

## 权限分类

* 普通权限：Android 6.0 以上不需要用户授权的权限，不属于危险权限的基本上都是普通权限
* 危险权限：Android 6.0 以上需要用户手动授权的权限，以下是所有的危险权限：

![](http://7xr2ek.com1.z0.glb.clouddn.com/image/jpg/android-permission.png)

## 申请权限

同意授权时需重写 `onRequestPermissionResult()` 方法：

``` java
    if (ContextCompat.checkSelfPermission(MainLayoutActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(MainLayoutActivity.this, new String[]{ Manifest.permission.CALL_PHONE }, 1);
    } else {
        call();
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
```

