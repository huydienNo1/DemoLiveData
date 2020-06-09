package com.example.demolivedata;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ControlFragment extends Fragment implements View.OnClickListener {

    private ImageButton imGoldplus, imGoldSub, imSilverPlus, imSilverSub, imBronzePlus, imBronzeSub;
    private TextView tvGold, tvSilver, tvBronze;
    private View root;
    private MedalViewModel medalViewModel = null;
    public ControlFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layout, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = layout.inflate(R.layout.fragment_control, container, false);
        imGoldplus = root.findViewById(R.id.btnGoldPlus);
        imSilverPlus = root.findViewById(R.id.btnSilverPlus);
        imBronzePlus = root.findViewById(R.id.btnBronzePlus);

        imGoldSub = root.findViewById(R.id.btnGoldSub);
        imSilverSub = root.findViewById(R.id.btnSilverSub);
        imBronzeSub = root.findViewById(R.id.btnBronzeSub);

        tvGold = root.findViewById(R.id.tvGold);
        tvSilver = root.findViewById(R.id.tvSilver);
        tvBronze = root.findViewById(R.id.tvBronze);

        medalViewModel = new ViewModelProvider(getActivity()).get(MedalViewModel.class);
        registerChangeMedalListener();

        return root;
    }

    private void registerChangeMedalListener() {
        medalViewModel.getGoldMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvGold.setText(String.valueOf(integer));
            }
        });

        medalViewModel.getSilverMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvSilver.setText(String.valueOf(integer));
            }
        });

        medalViewModel.getBronzeMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvBronze.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imGoldplus.setOnClickListener(this);
        imGoldSub.setOnClickListener(this);
        imSilverPlus.setOnClickListener(this);
        imSilverSub.setOnClickListener(this);
        imBronzePlus.setOnClickListener(this);
        imBronzeSub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGoldPlus:
                medalViewModel.addGoldMedal();
                break;
            case R.id.btnSilverPlus:
                medalViewModel.addSilverMedal();
                break;
            case R.id.btnBronzePlus:
                medalViewModel.addBronzeMedal();
                break;
            case R.id.btnGoldSub:
                medalViewModel.subGoldMedal();
                break;
            case R.id.btnSilverSub:
                medalViewModel.subSilverMedal();
                break;
            case R.id.btnBronzeSub:
                medalViewModel.subBronzeMedal();
                break;

        }

    }
}
