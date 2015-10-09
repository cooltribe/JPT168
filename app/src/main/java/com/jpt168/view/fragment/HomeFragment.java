package com.jpt168.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jpt168.R;

/**
 * Created by caomingyu on 15/9/16.
 * email:361786231@qq.com
 */
public class HomeFragment extends Fragment{

    ImageButton backImageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        backImageButton = (ImageButton) view.findViewById(R.id.back_imagebutton);
        backImageButton.setVisibility(View.GONE);
        return view;
    }
}
