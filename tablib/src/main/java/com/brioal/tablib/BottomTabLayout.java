package com.brioal.tablib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import java.util.List;


public class BottomTabLayout extends RadioGroup {
    private List<TabEntity> mList;
    private OnTabSelectedListener mListener;
    private int mColorNormal;
    private int mColorSelected;


    public BottomTabLayout(Context context) {
        this(context, null);
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setColorNormal(int colorNormal) {
        mColorNormal = colorNormal;
    }

    public void setColoeSelected(int coloeSelected) {
        mColorSelected = coloeSelected;
    }

    public void setListener(OnTabSelectedListener listener) {
        mListener = listener;
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setPadding(5, 5, 5, 0);
        mColorNormal = getResources().getColor(R.color.normal);
        mColorSelected = getResources().getColor(R.color.selected);
    }

    public void setSelectedPosition(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            if (position == i) {
                getChildAt(i).setSelected(true);
            } else {
                getChildAt(i).setSelected(false);
            }
        }
        mListener.onSelected(position);
    }

    public void setList(List<TabEntity> list) {
        mList = list;
        for (int i = 0; i < mList.size(); i++) {
            final BottomTab tab = new BottomTab(getContext());
            final TabEntity entity = mList.get(i);
            tab.setColorNormal(mColorNormal);
            tab.setColorSelect(mColorSelected);
            tab.setIcon(getContext().getResources().getDrawable(entity.getIcon()));
            tab.setText(entity.getTitle());
            tab.setId(Integer.valueOf(i));
            tab.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.MATCH_PARENT, 1));
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onSelected(v.getId());
                    }
                    for (int j = 0; j < getChildCount(); j++) {
                        if (getChildAt(j).getId() == v.getId()) {
                            getChildAt(j).setSelected(true);
                        } else {
                            getChildAt(j).setSelected(false);
                        }
                    }
                }
            });
            if (i == 0) {
                tab.setSelected(true);
            }
            addView(tab);
        }
    }
}
