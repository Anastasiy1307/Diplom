package com.example.diplom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Chart extends BaseAdapter {

    private Context nContext;
    private ArrayList<Mask_Chart> mMask;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_Chart(Context nContext, List<Mask_Chart> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<Mask_Chart>  maskList;

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


        View v =View.inflate(nContext,R.layout.activity_mask_chart,null);

        TextView group=v.findViewById(R.id.textgroup);
        TextView resulta=v.findViewById(R.id.resulta);
        TextView data=v.findViewById(R.id.data);

        Mask_Chart mask=maskList.get(position);
        group.setText(Integer.toString(mask.getID()));
        resulta.setText(mask.getResult());
        data.setText(mask.getDate());
        return v;
    }
}

