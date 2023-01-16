package com.example.unit8;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        final TabLayout tabLayout=(TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Log.i("tab:", String.valueOf(tab.getPosition()));
                switch (tab.getPosition()){
                    case 0: fragment=new Fragmento_primero(); break;
                    case 1: fragment=new Fragmento_segundo(); break;
                    case 2: fragment=new Fragmento_tercero(); break;
                    default:fragment=new Fragmento_primero(); break;
                }

                //if(tab.getPosition()==0)fragment=new Fragmento_primero();
                ft.replace(R.id.contenedor,fragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
                /*
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, mFeedFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                 */
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}