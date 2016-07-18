package com.example.dashmesh.a_fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String[] Exams;
    public MainActivityFragment() {
    //empty constructor
    }

    public interface OnItemClick {
        void onItemClick(String Exams);
    }
    private OnItemClick mListener;

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnItemClick) {
            mListener = (OnItemClick) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }

        final Resources resources = context.getResources();
        Exams = resources.getStringArray(R.array.exams);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      //Button  btn = (Button) container.findViewById(R.id.button);
        //btn.setOnClickListener(this);
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View rootView = inflater.inflate(R.layout.fragment_main, container,false);

        final Activity activity = getActivity();
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 1));
        recyclerView.setAdapter(new ExamAdapter(activity));

        return rootView;
    }


    class ExamAdapter extends RecyclerView.Adapter<ViewHolder> {

        private LayoutInflater mLayoutInflater;

        public ExamAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            return new ViewHolder(mLayoutInflater
                    .inflate(R.layout.recycler_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            final String exams = Exams[position];

            viewHolder.setData(exams);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(exams);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Exams.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // Views
        private TextView mNameTextView;

        private ViewHolder(View itemView) {
            super(itemView);

            // Get references to image and name.
            // mImageView = (ImageView) itemView.findViewById(R.id.comic_image);
            mNameTextView = (TextView) itemView.findViewById(R.id.name);
        }

        private void setData(String name) {
            // mImageView.setImageResource(imageResId);
            mNameTextView.setText(name);
        }
    }
}
