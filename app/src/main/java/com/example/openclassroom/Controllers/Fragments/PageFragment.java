package com.example.openclassroom.Controllers.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.openclassroom.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private  static final String KEY_POSITION="position";
    private  static final String KEY_COLOR="color";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PageFragment() {
        // Required empty public constructor
    }
    public static PageFragment newInstance(int position,int color){
        PageFragment pageFragment =new PageFragment() ;

        Bundle bundle=new Bundle();

        bundle.putInt(KEY_POSITION,position);
        bundle.putInt(KEY_COLOR,color);

        pageFragment.setArguments(bundle);

        return pageFragment;
    }


    public static PageFragment newInstance(String param1, String param2) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //ceci est le fragment
        View view= inflater.inflate(R.layout.fragment_page, container, false);

        int color=getArguments().getInt(KEY_COLOR,-1);
        int positon=getArguments().getInt(KEY_POSITION,-1);
        TextView textView=(TextView)  view.findViewById(R.id.fragment_page_texview);
        LinearLayout rootView=(LinearLayout)  view.findViewById(R.id.fragment_page_root_view);

        rootView.setBackgroundColor(color);
        textView.setText("Page numéro " +positon);


        return rootView;
    }
}