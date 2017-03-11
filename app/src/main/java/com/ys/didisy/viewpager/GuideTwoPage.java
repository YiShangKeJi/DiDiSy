package com.ys.didisy.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.ys.didisy.R;

public class GuideTwoPage {
     public View view;
     private Context mContext;
     
     public GuideTwoPage(Context context){
    	 mContext=context;
    	 view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_two, null);
     }
}
