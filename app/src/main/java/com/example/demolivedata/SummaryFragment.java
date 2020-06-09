package com.example.demolivedata;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryFragment extends Fragment {

    private MedalViewModel mViewModel = null;
    private View root;
    private TextView tvSummary;
    private int totalMedal = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.summary_fragment, container, false);
        tvSummary = root.findViewById(R.id.tvSummary);
        mViewModel = new ViewModelProvider(getActivity()).get(MedalViewModel.class);
        registerListener();

        return root;
    }

    private void registerListener() {
        mViewModel.getGoldMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displaySummaryMedal();
            }
        });

        mViewModel.getSilverMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displaySummaryMedal();
            }
        });

        mViewModel.getBronzeMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displaySummaryMedal();
            }
        });
    }

    private void displaySummaryMedal() {
        totalMedal = mViewModel.getGoldMedal().getValue() + mViewModel.getSilverMedal().getValue() + mViewModel.getBronzeMedal().getValue();
        tvSummary.setText(String.valueOf(totalMedal));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
