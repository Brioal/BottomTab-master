package com.brioal.bottomtab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.brioal.tablib.BottomTabLayout;
import com.brioal.tablib.OnTabSelectedListener;
import com.brioal.tablib.TabEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomTabLayout mLayout;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (BottomTabLayout) findViewById(R.id.main_tab);
        List<TabEntity> list = new ArrayList<>();
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
    }
}
