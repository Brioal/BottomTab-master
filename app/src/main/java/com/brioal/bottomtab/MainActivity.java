package com.brioal.bottomtab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brioal.tablib.BottomTabLayout;
import com.brioal.tablib.OnTabSelectedListener;
import com.brioal.tablib.TabEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    BottomTabLayout mLayout;
    private Toast mToast;
    private List<TabEntity> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (BottomTabLayout) findViewById(R.id.main_tab);
        mList.add(new TabEntity("标题1", R.mipmap.ic_launcher));
        mList.add(new TabEntity("标题2", R.mipmap.ic_launcher));
        mList.add(new TabEntity("标题3", R.mipmap.ic_launcher));
        mList.add(new TabEntity("标题4", R.mipmap.ic_launcher));
        mLayout.setColorNormal(Color.WHITE);
        mLayout.setColoeSelected(Color.YELLOW);
        mLayout.setList(mList);
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

    public void changeSelect(View view) {
        Random random = new Random();
        int index = random.nextInt(mList.size());
        mLayout.setSelectedPosition(index);
        Button button = (Button) view;
        button.setText(index + "");
    }
}
