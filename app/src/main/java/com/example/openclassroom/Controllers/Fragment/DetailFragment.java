package com.example.openclassroom.Controllers.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.openclassroom.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView textView;
    private  int buttoTage;
    private  static final String KEY_BUTTON_TAG="com.example.openclassroom.Controllers.Fragment.DetailFragment.KEY_BUTTON_TAG";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTON_TAG,buttoTage);
        // System.out.println("onsave "+buttoTage);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //int buttonTagRestore=savedInstanceState.getInt(KEY_BUTTON_TAG,buttoTage);
        // System.out.println("buttonTagRestore: "+buttonTagRestore);

        if(savedInstanceState!=null){
          //  int  buttonTagRestore=savedInstanceState.getInt(KEY_BUTTON_TAG,buttoTage);
            int  buttonTagRestore=savedInstanceState.getInt(KEY_BUTTON_TAG,buttoTage);
            this.updateTextView(2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_detail, container, false);

        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        this.textView=(TextView) view.findViewById(R.id.fragment_layout_detail_textview);
        return  view;

    }

    public void updateTextView(int buttonTag) {
        switch (buttonTag){
            case 0:
                this.textView.setText("O");
                break;
            case 10:
                this.textView.setText("10");
                break;
            case 20:
                this.textView.setText("20");
                break;
            case 30:
                this.textView.setText("30");
                break;
            default:
                break;
        }
    }
}