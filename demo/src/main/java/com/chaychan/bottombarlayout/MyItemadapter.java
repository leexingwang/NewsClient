package com.chaychan.bottombarlayout;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class MyItemadapter extends RecyclerView.Adapter<MyItemadapter.ViewHolder> implements View.OnClickListener {
    private String[] datas;
    private Fragment fragment;

    public MyItemadapter(String[] datas, Fragment fragment) {
        this.datas = datas;
        this.fragment = fragment;
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        try {
            Glide.with(fragment)                             //配置上下文
                    .load(datas[position])      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                    .error(R.mipmap.ic_launcher)//设置错误图片
//                    .placeholder(R.mipmap.ic_launcher)//设置占位图片
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存原始图片
//                    .skipMemoryCache(true)
                    .into(viewHolder.mTextView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.length;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mTextView;
        public ShimmerLayout shimmerLayout;

        public ViewHolder(View view) {
            super(view);
            mTextView = (ImageView) view.findViewById(R.id.img);
            shimmerLayout = (ShimmerLayout) view.findViewById(R.id.shimmer_text);
        }
    }
}
