package com.example.dashmesh.a_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainDisplayFragment extends Fragment {

    public MainDisplayFragment() {
        //empty constructor
    }

    public interface OnButton2Click {
        void onButton2Click();
    }
    private OnButton2Click mListener2;

    public interface OnButton3Click {
        void onButton3Click();
    }
    private OnButton3Click mListener3;

    public static MainDisplayFragment newInstance() {
        return new MainDisplayFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnButton2Click) {
            mListener2 = (OnButton2Click) context;
        }
        if (context instanceof OnButton3Click) {
            mListener3 = (OnButton3Click) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_display, container,false);

        Button btn2 = (Button) rootView.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                mListener2.onButton2Click();
            }
        });

    Button btn3 = (Button) rootView.findViewById(R.id.button3);
    btn3.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            mListener3.onButton3Click();
        }
    });

    return rootView;
}

}
