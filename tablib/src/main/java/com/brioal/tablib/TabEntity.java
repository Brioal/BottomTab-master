package com.brioal.tablib;

/**
 * BottomTab Layout Entity
 * Created by Brioal on 2016/10/2.
 */

public class TabEntity {
    private int mIcon;
    private String mTitle;

    public TabEntity() {

    }

    public TabEntity(String title, int icon) {
        mIcon = icon;
        mTitle = title;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
