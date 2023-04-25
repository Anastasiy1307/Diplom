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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Adapter_Tests extends BaseAdapter {
    Button Test;
    private Context nContext;
    private ArrayList<Maska_Tests> mMask;
    private OnItemClickListener mListener;
    String img="";

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public Adapter_Tests(Context nContext, List<Maska_Tests> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<Maska_Tests>  maskList;

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {return maskList.get(i);
    }

    @Override
    public long getItemId(int i) {return maskList.get(i).getID();}

    public static Bitmap loadContactPhoto(ContentResolver cr, long id, Context context) {
        Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id);
        InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr, uri);
        if (input == null) {
            Resources res = context.getResources();
            return BitmapFactory.decodeResource(res, R.drawable.nophoto);
        }
        return BitmapFactory.decodeStream(input);
    }


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



        View v =View.inflate(nContext,R.layout.activity_maska_tests,null);

        TextView NameTest=v.findViewById(R.id.name);
        TextView Short_desription= v.findViewById(R.id.Short);
        ImageView Image= v.findViewById(R.id.Progress);
        Button Test = v.findViewById(R.id.start);

        Maska_Tests mask=maskList.get(position);

        NameTest.setText(mask.getName_test());
        Short_desription.setText(mask.getShort_descroption());

        Image.setImageBitmap(getUserImage(mask.getImage()));

        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenDetalis=new Intent(nContext,Questions.class);
                intenDetalis.putExtra("test",mask);
                nContext.startActivity(intenDetalis);
            }
        });

        return v;
    }


}
