package com.example.diplom;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Adapter_questions extends BaseAdapter {
    private RadioButton  not;
    private RadioButton skor_not;
    private RadioButton in_yes;
    int bal;
    private TextView ball;
    private RadioButton scor_yes;
    private RadioButton yes;
    private Context nContext;
    private ArrayList<Maska_Questions> mMask;
    private OnItemClickListener mListener;
    String img="";


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_questions(Context nContext, List<Maska_Questions> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<Maska_Questions>  maskList;

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


        View v = View.inflate(nContext, R.layout.activity_maska_questions, null);

        TextView question = v.findViewById(R.id.q1);

        Maska_Questions mask = maskList.get(position);

        question.setText(mask.getQuestion());



        not = (RadioButton) v;
        mask.getQuestion(not.getId()).setSelected(true);

        return v;
    }

    public void onClick(View v) {
        RadioButton btn = (RadioButton) v;
        Maska_Questions mask = maskList.get(position);
        question.unselectAll(); // unselects all Answer
        question.getAnswer(btn.getId()).setSelected(true);
    }



}





