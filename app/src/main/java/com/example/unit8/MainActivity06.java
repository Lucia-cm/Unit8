package com.example.unit8;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity06 extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView=(NavigationView) findViewById(R.id.navigator);

        if(navigationView!=null)
            configuraDrawer(navigationView);

    }
    private void configuraDrawer(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                String title=item.getTitle().toString();

                Toast.makeText(getApplication(),title,Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

}