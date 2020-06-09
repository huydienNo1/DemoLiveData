package com.example.demolivedata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {
    private MedalViewModel mViewModel = null;
    private View root;
    private TextView tvGold, tvSilver, tvBronze;

    @Override
    public View onCreateView(LayoutInflater layout, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = layout.inflate(R.layout.fragment_detail, container, false);
        tvGold = root.findViewById(R.id.tvGoldDetail);
        tvSilver = root.findViewById(R.id.tvSilverDetail);
        tvBronze = root.findViewById(R.id.tvBronzeDetail);

        mViewModel = new ViewModelProvider(getActivity()).get(MedalViewModel.class);
        registerListener();
        return root;
    }

    private void registerListener() {
        mViewModel.getGoldMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvGold.setText(mViewModel.getGoldMedal().getValue() + " " + getString(R.string.hc_vang));
            }
        });

        mViewModel.getSilverMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvSilver.setText(mViewModel.getSilverMedal().getValue() + " " + getString(R.string.hc_bac));
            }
        });

        mViewModel.getBronzeMedal().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvBronze.setText(mViewModel.getBronzeMedal().getValue() + " "+ getString(R.string.hc_dong));
            }
        });
    }
}

