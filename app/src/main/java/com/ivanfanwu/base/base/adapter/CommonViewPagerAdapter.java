package com.ivanfanwu.base.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class CommonViewPagerAdapter extends FragmentPagerAdapter{

    private String[] mTitles;
    private List<Fragment> mFragments = new ArrayList<>();

    public CommonViewPagerAdapter(FragmentManager fm,String []titles) {
        super(fm);
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
