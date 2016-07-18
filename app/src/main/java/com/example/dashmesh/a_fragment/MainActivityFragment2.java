package com.example.dashmesh.a_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment2 extends Fragment {

    public MainActivityFragment2() {
        //empty constructor
    }

    public interface OnButtonClick {
        void onButtonClick();
    }
    private OnButtonClick mListener;

    public static MainActivityFragment2 newInstance() {
        return new MainActivityFragment2();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Button  btn = (Button) container.findViewById(R.id.button);
        //btn.setOnClickListener(this);
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View rootView = inflater.inflate(R.layout.fragment_main2, container,false);

        return rootView;
    }

}
