package com.example.diplom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Questions4 extends BaseAdapter {

    private Context nContext;
    private ArrayList<maska_questions4> mMask;
    private OnItemClickListener mListener;
    String img="";

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }



    public Adapter_Questions4(Context nContext, List<maska_questions4> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<maska_questions4>  maskList;

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


        View v =View.inflate(nContext,R.layout.activity_maska_questions4,null);

        TextView question=v.findViewById(R.id.q1);


        maska_questions4 mask=maskList.get(position);

        question.setText(mask.getQuestion());

        return v;
    }
}