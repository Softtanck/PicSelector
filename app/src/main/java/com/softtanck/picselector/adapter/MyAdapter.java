package com.softtanck.picselector.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softtanck.picselector.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/14/2015
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private Context context;
    private List<String> list;

    private Map<Integer, Boolean> isCheck;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        isCheck = new HashMap<>();

    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewholder myViewholder = new MyViewholder(View.inflate(context, R.layout.item, null));
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(final MyViewholder myViewhold, final int i) {

        if (null != isCheck.get(i) && isCheck.get(i))
            myViewhold.imageView.setImageBitmap(null);
        myViewhold.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tanck", "onclick:" + i);
                myViewhold.imageView.setImageBitmap(null);
                isCheck.put(i, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MyViewholder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
