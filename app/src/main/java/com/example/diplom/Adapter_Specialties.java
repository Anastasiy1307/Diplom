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

public class Adapter_Specialties extends BaseAdapter {

    private Context nContext;
    private ArrayList<Mask_specialties> mMask;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_Specialties(Context nContext, List<Mask_specialties> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<Mask_specialties>  maskList;

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


        View v =View.inflate(nContext,R.layout.activity_mask_specialties,null);

        TextView Kod=v.findViewById(R.id.cod);
        TextView Name=v.findViewById(R.id.Name_Specialities);

        Mask_specialties mask=maskList.get(position);
        Kod.setText(mask.getCode_specialtires());
        Name.setText(mask.getName_specialties());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenDetalis=new Intent(nContext,Specialties.class);
                intenDetalis.putExtra("korpus",mask);
                nContext.startActivity(intenDetalis);

            }
        });
        return v;
    }
}
