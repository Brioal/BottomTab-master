# 适用于切换只是颜色改变的BottomTabLayout
### Step 1. Add the JitPack repository to your build file

#### Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
### Step 2. Add the dependency [![](https://jitpack.io/v/Brioal/BottomTab-master.svg)](https://jitpack.io/#Brioal/BottomTab-master)
```
	dependencies {
	        compile 'com.github.Brioal:BottomTab-master:1.1'
	}
```

#### 使用步骤
#### 1.xml
```
    <com.brioal.tablib.BottomTabLayout
        android:id="@+id/main_tab"
        android:layout_alignParentBottom="true"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </com.brioal.tablib.BottomTabLayout>

```
#### 2.设置
```
 list.add(new TabEntity("标题1", R.mipmap.ic_launcher));
        list.add(new TabEntity("标题2", R.mipmap.ic_launcher));
        list.add(new TabEntity("标题3", R.mipmap.ic_launcher));
        list.add(new TabEntity("标题4", R.mipmap.ic_launcher));
        mLayout.setList(list);
        mLayout.setListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {
                if (mToast == null) {
                    mToast = Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_LONG);
                } else {
                    mToast.setText(position + "");
                }
                mToast.show();
            }
        });
```
### 同样可设置未读消息,参考[BottomTabLayout](https://github.com/Brioal/BottomTabLayout)
