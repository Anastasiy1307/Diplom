package com.example.diplom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_group extends BaseAdapter {

    private Context nContext;
    private ArrayList<maska_group> mMask;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_group(Context nContext, List<maska_group> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<maska_group>  maskList;

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


        View v =View.inflate(nContext,R.layout.activity_maska_group,null);

        TextView Name_group=v.findViewById(R.id.Groupp);


        maska_group mask=maskList.get(position);
        Name_group.setText(mask.getName_group());


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenDetalis=new Intent(nContext,Specialties.class);
                intenDetalis.putExtra("group",mask);
                nContext.startActivity(intenDetalis);

            }
        });
        return v;
    }
}
