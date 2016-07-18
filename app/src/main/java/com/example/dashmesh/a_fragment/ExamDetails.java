package com.example.dashmesh.a_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExamDetails extends Fragment {

    public ExamDetails() {
        //empty constructor
    }

    public interface OnButtonClick {
        void onButtonClick();
    }
    private OnButtonClick click;

    public static ExamDetails newInstance() {
        return new ExamDetails();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClick) {
            click = (OnButtonClick) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement ");
        }


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.exam_details, container,false);

        Bundle bundle = this.getArguments();
        String exam = bundle.getString("key", null);

        TextView myAwesomeTextView = (TextView)rootView.findViewById(R.id.text);

        myAwesomeTextView.setText(exam + " " +"details");
        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                click.onButtonClick();
            }
        });

        return rootView;
    }

}
