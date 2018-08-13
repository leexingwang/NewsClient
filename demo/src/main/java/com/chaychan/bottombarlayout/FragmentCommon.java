package com.chaychan.bottombarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FragmentCommon extends Fragment {

    private static final String ARG_SECTION_NUMBER = "text";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private List<FragmentItem> fragmentItems = new ArrayList<>();

    public static FragmentCommon newInstance(String text) {
        FragmentCommon fragmentCommon = new FragmentCommon();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SECTION_NUMBER, text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.item_layout, container, false);
        }
        return rootView;
    }

    int count;
    SlidingTabLayout tabLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mSectionsPagerAdapter == null) { // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            fragmentItems.clear();
            Random rand = new Random();
            int namej = 1 + rand.nextInt(5);
            for (int i = 1; i <= namej; i++) {
                Random rand1 = new Random();
                int nameL = 1 + rand1.nextInt(5);
                String name = "SECTION";
                for (int j = 0; j < nameL; j++) {
                    name = name + j;
                }
                fragmentItems.add(FragmentItem.newInstance(name));
            }
            mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager(), fragmentItems);
            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) rootView.findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);
            tabLayout = (SlidingTabLayout) rootView.findViewById(R.id.tl_2);
            mViewPager.setOffscreenPageLimit(1);
            mViewPager.setCurrentItem(0);
            tabLayout.setViewPager(mViewPager);
            tabLayout.setCurrentTab(0);
//            tabLayout.setIndicatorWidthEqualTitle(true);
            if (namej > 3) {
                tabLayout.setTabSpaceEqual(false);
            } else {
                tabLayout.setTabSpaceEqual(true);
            }
            tabLayout.notifyDataSetChanged();
//            mViewPager.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    fragmentItems.add(3, FragmentItem.newInstance(("SECTION" + "7")));
//                    mSectionsPagerAdapter.notifyDataSetChanged();
//                }
//            }, 5000);
//            layoutTab();
        }
    }


//    private void layoutTab() {
//        int width = 0;
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
////            width += tabLayout.getTabAt(i).getText()
//            width = (width + (int) getTextWidth(tabLayout.getTabAt(i).getText().toString(), 40) + 2 * dpToPx(16));
//
//        }
//        if (width < 1442) {
//            tabLayout.setTabMode(TabLayout.GRAVITY_FILL);
//        } else {
//            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        }
//
//    }

    private int dpToPx(int dps) {
        return Math.round(getResources().getDisplayMetrics().density * dps);
    }

    /**
     * 根据文本的
     *
     * @param text
     * @param textSize
     * @return
     */
    public float getTextWidth(String text, float textSize) {

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(textSize);
        return textPaint.measureText(text);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER) + " :" + "onResume");
//        layoutTab();
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER) + " :" + "onPause");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER) + " :" + "onCreate");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER) + " :" + "onStop");
    }


}
