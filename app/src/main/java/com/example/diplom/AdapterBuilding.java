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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AdapterBuilding extends BaseAdapter {

    private Context nContext;
    private ArrayList<Buildings> mMask;
    private OnItemClickListener mListener;
    String img="";
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public AdapterBuilding(Context nContext, List<Buildings> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<Buildings>  maskList;

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {return maskList.get(i);
    }

    @Override
    public long getItemId(int i) {return maskList.get(i).getID();}




    private Bitmap getUserImage(String encodedImg)
    {
        byte[] bytes;
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {

            return BitmapFactory.decodeResource(nContext.getResources(), R.drawable.nophoto);
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v =View.inflate(nContext,R.layout.activity_buildings,null);

        TextView ID=v.findViewById(R.id.name);
       ImageView Image= v.findViewById(R.id.PhotoKorp);

        Buildings mask=maskList.get(position);
        ID.setText(mask.getNumber());


        Image.setImageBitmap(getUserImage(mask.getImg()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenDetalis=new Intent(nContext,Korpus.class);
                intenDetalis.putExtra("korpus",mask);
                nContext.startActivity(intenDetalis);

            }
        });
        return v;
    }
}
