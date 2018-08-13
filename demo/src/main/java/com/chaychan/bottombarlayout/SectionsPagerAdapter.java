package com.chaychan.bottombarlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixingwang on 2018/8/8.
 * com.chaychan.bottombarlayout
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentItem> fragmentItems = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm, List<FragmentItem> fragmentItems) {
        super(fm);
        this.fragmentItems = fragmentItems;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentItems.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return fragmentItems.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentItems.get(position).getArguments().getString("section_number");
    }
}
