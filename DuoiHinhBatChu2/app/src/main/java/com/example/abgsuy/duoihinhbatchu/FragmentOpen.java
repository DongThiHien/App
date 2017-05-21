package com.example.abgsuy.duoihinhbatchu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Abgsuy on 16/05/2017.
 */

public class FragmentOpen extends Fragment implements View.OnClickListener {
    private Button mBtnPlay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_open,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnPlay = (Button) view.findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentPlay mFrPlay = new FragmentPlay();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.first_in,R.anim.first_out,
                                        R.anim.sec_in,R.anim.sec_out);
        transaction.replace(R.id.fr_layout,mFrPlay,mFrPlay.getClass().getName());
        transaction.addToBackStack("k");
        transaction.commit();
    }
}
