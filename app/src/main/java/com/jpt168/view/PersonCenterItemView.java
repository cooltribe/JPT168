package com.jpt168.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jpt168.R;

/**
 * Created by Administrator on 2015/9/24.
 */
public class PersonCenterItemView extends RelativeLayout {

    private TextView leftTextView;
    private TextView centerTextView;
    private EditText centerEditTextw;
    private ImageView imageView;

    public PersonCenterItemView(Context context) {
        super(context);
        init(context);
    }

    public PersonCenterItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PersonCenterItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.view_person_center,this);
        leftTextView = (TextView) view.findViewById(R.id.left_text);
        centerTextView = (TextView) view.findViewById(R.id.center_text);
        centerEditTextw = (EditText) view.findViewById(R.id.center_edittext);
        imageView = (ImageView) view.findViewById(R.id.img);


    }
    public void setLeftText(int drawableResource,String string){
        Drawable drawable = getResources().getDrawable(drawableResource);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        leftTextView.setText(string);
        leftTextView.setCompoundDrawables(drawable, null, null, null);
    }
    public void setCenterTextView(String string){
        centerTextView.setText(string);
    }
    public void setTextViewVisibility(int visibility){
        centerTextView.setVisibility(visibility);
    }
    public void setEditTextVisibility(int visibility){
        centerTextView.setVisibility(visibility);
    }
    public void setImg(int drawableResource){
        imageView.setImageResource(drawableResource);
    }
}
