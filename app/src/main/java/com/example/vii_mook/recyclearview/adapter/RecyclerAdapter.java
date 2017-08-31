package com.example.vii_mook.recyclearview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vii_mook.recyclearview.R;
import com.example.vii_mook.recyclearview.model.Landscape;

import java.util.List;

/**
 * Created by vii-mook on 8/30/2017 AD.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Landscape> mData;
    private LayoutInflater mInflater;

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    public RecyclerAdapter(Context context, List<Landscape> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onCreateViewHolder" + position);

        Landscape current = mData.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

   class MyViewHolder extends RecyclerView.ViewHolder {

       TextView title;
       ImageView imgThumb,imgDelete, imgAdd;
       int position;
       Landscape current;

       public MyViewHolder(View itemview) {
           super(itemview);

           title = (TextView) itemview.findViewById(R.id.tvTitle);
           imgThumb = (ImageView) itemview.findViewById(R.id.img_row);
           imgAdd = (ImageView) itemview.findViewById(R.id.img_row_add);
           imgDelete = (ImageView) itemview.findViewById(R.id.img_row_delete);
       }

       public void setData(Landscape current, int position) {
           this.title.setText(current.getTitle());
           this.imgThumb.setImageResource(current.getImageID());
           this.position = position;
           this.current = current;
       }
   }
}
