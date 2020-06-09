package com.example.demolivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MedalViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> GoldMedal = new MutableLiveData<>();
    private MutableLiveData<Integer> SilverMedal = new MutableLiveData<>();
    private MutableLiveData<Integer> BronzeMedal = new MutableLiveData<>();


    public MedalViewModel(@NonNull Application application) {
        super(application);
        GoldMedal.setValue(0);
        SilverMedal.setValue(0);
        BronzeMedal.setValue(0);
    }

    public MutableLiveData<Integer> getGoldMedal() {
        return GoldMedal;
    }

    public MutableLiveData<Integer> getSilverMedal() {
        return SilverMedal;
    }

    public MutableLiveData<Integer> getBronzeMedal() {
        return BronzeMedal;
    }

    public void addGoldMedal() {
        GoldMedal.setValue(GoldMedal.getValue() + 1);
    }

    public void addSilverMedal() {
        SilverMedal.setValue(SilverMedal.getValue() + 1);
    }

    public void addBronzeMedal() {
        BronzeMedal.setValue(BronzeMedal.getValue() + 1);
    }

    public void subGoldMedal() {
        GoldMedal.setValue(GoldMedal.getValue() - 1);
    }

    public void subSilverMedal() {
        SilverMedal.setValue(SilverMedal.getValue() - 1);
    }

    public void subBronzeMedal() {
        BronzeMedal.setValue(BronzeMedal.getValue() - 1);
    }
}
