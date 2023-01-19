package com.example.unit8;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Adapter extends FragmentStatePagerAdapter {
    int numTab;

    public Adapter(@NonNull FragmentManager fm, int numTab) {
        super(fm);
        this.numTab=numTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: Fragmento_primero fp=new Fragmento_primero();
                    return fp;
            case 1: Fragmento_segundo fs=new Fragmento_segundo();
                    return fs;
            case 2: Fragmento_tercero ft=new Fragmento_tercero();
                    return ft;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
