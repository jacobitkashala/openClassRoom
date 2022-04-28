package com.example.openclassroom.Controllers.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.openclassroom.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment. implements View.OnClickListener {
 */

public class MainFragment extends Fragment implements  View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // cette collback permet de lien le fragment a notre activité
    private onButtonClickedListener mCallback;

    /*On declare une interface dans le but d'obliger toute activité
  qui veulle communiquer avec cette fragment d'implementer la methode  onButton ClickedListener
   */
    public  interface onButtonClickedListener{

        public void onButtonCliked(View view);
    }
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

    /**
    * Permet de créer la vue du fragment
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result= inflater.inflate(R.layout.fragment_main, container, false);
       /*
       * On capte tout le click
       * */
        result.findViewById(R.id.fragment_main_button).setOnClickListener(this);
        return result;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    @Override
    public void onClick(View view) {
        mCallback.onButtonCliked(view);
    }
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (onButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}