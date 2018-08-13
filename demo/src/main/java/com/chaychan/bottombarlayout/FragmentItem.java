package com.chaychan.bottombarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by lixingwang on 2018/8/8.
 * com.chaychan.bottombarlayout
 */

public class FragmentItem extends BasePageFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER1 = "section_number";

    public FragmentItem() {
    }

    String[] datas = new String[]{
            "http://imgcdn.yicai.com/uppics/slides/2018/08/68ad66b93c31327983e91caaf21683dc.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/68ad66b93c31327983e91caaf21683dc.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/1eec45402ac4902a7deb723f24aead38.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/89b9d61ac605a5d808a11a9e7f60d0af.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/6996bea7810b0411162783aa4b2daa7b.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/1029e4faf5f0e8ac37b195286082f7da.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/9bcb51063aec148a9ebe76d0c631de43.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/26e63eb0bb933f34113e93e5a7f75de8.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/fad9cf8977a523e45c5da003e08f270e.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/4ec284326120d21c57aa33de8ca46533.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/3fd06a29b5a721bb79255affa9541438.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/f7245952f149460a86b34a840186dfc6.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/49bdb087428ff23aae0a44864f47f860.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/732caac33ba953566446b7f274d02b81.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/d49542bb0a79f225eed1c13fbb79b03a.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/fee26cdf929f7a7753c9d75d566928d7.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/cc61b6fecc2185795ae6dd2783133e14.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/3cdc0ca40249e63692a6e43fdb9e5ccb.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/d3712cf6207eaa1e4aff80521a8b9244.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/69585c6caa09af7f53b1edcc1df85cec.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/a4aead60caf69584e8f565e7937637fe.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/e6534b0d03478558e4aee8e5ea27c3d0.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/d19f4d65e0cc05c19614fa8e565ad1ff.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/2fdf71e90009a48559f84820d6cd0cda.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/c5a8ac007f150ec07a21b2f9ac20fc12.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/0b0c271bca08ce3a7a74bc9303b99b22.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/32b6fcaafd6643d1323083ccf175e3b7.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/08f8285725580db96d966df3864bc148.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/f724b1e41d1aee44f183bedfa115c869.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/08f8285725580db96d966df3864bc148.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/f724b1e41d1aee44f183bedfa115c869.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/5c9047e1f6d9ccfd081eff25026dc259.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/bd5d4a08ed3880aa40a63c68814ec907.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/52f3572a8bbdbf825f22580b219451bf.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/3e5a4a6901a15e8e10acc03d7bfd0850.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/27ca35fad22d44df64e38d4794b44c9c.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/1138d805c604d5b89ad3a2cb6ceb382b.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/b9ccfd7bac0739c8c64a5eb32bdf3a2e.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/56ed535de503f772695964fae077b55e.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/4fd0369502f3538e1f664fb3cc463e6c.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/872ac2078ecc5f99c04acf6b90af638f.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/f9e57130238c9d87ec660f0761da8fd1.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/11ad3662fcfca53027d045c04e45492b.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/ad631253c1d9c8f2ae5e1309e80f5bc0.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/352bed669fedde2ae6703efb6f75fc1f.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/50c5bab62e5c8081ab6b6b4d2b18fa6a.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/c0bd69d1cf2e7f88de1efe24dcb3d517.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/f72614b697a31326bb7bec68bf6591eb.jpg",
            "http://imgcdn.yicai.com/uppics/slides/2018/08/17194224cf41bd07a9ece45dece88baa.jpg"};

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentItem newInstance(String sectionNumber) {
        FragmentItem fragment = new FragmentItem();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER1, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onPause");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onDestroyView");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), getArguments().getString(ARG_SECTION_NUMBER1) + " :" + "onActivityCreated");
    }

    @Override
    public void fetchData() {

    }

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
        }

        return rootView;
    }

    MyItemadapter mAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mAdapter == null) {
            XRecyclerView mRecyclerView = (XRecyclerView) rootView.findViewById(R.id.recyclerview);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setPullRefreshEnabled(true);
            //没有数据，触发emptyView
            mAdapter = new MyItemadapter(datas, this);
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();

    }
}
