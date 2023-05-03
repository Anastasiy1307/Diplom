package com.example.diplom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Questions3 extends BaseAdapter {

    private Context nContext;
    private ArrayList<masks_Questions3> mMask;
    private OnItemClickListener mListener;
    String img="";

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }



    public Adapter_Questions3(Context nContext, List<masks_Questions3> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<masks_Questions3>  maskList;

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


        View v =View.inflate(nContext,R.layout.activity_masks_questions3,null);

        TextView question=v.findViewById(R.id.q1);


        masks_Questions3 mask=maskList.get(position);

        question.setText(mask.getQuestion());

        return v;
    }
}
