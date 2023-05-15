package com.example.diplom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_reskorpus extends BaseAdapter {

    private Context nContext;
    private ArrayList<mask_result> mMask;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_reskorpus(Context nContext, List<mask_result> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<mask_result>  maskList;

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {return maskList.get(i);
    }

    @Override
    public long getItemId(int i) {return maskList.get(i).getID();}






    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v =View.inflate(nContext,R.layout.activity_mask_result,null);

        TextView group=v.findViewById(R.id.group);
        TextView resulta=v.findViewById(R.id.resulta);
        TextView data=v.findViewById(R.id.data);

        mask_result mask=maskList.get(position);
        group.setText(mask.getName_group());
        resulta.setText(mask.getResult());
        data.setText(mask.getDate());











        return v;
    }
}
