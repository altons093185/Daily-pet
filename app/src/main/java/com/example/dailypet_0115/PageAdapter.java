package com.example.dailypet_0115;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;



    PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;


    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new dogstep_fragment();
            case 1:
                return new remind_fragment();
            case 2:
                return new healthrecord_fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }


}
