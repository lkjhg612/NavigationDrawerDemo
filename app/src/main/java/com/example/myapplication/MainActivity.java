package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar; // Dùng cho setSupportActionBar(toolbar);

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_camera:
                        Toast.makeText(MainActivity.this, "CLICKED TO CAMERA", Toast.LENGTH_SHORT).show();break;
                    case  R.id.nav_gallery:
                        Toast.makeText(MainActivity.this, "CLICKED TO GALLERY", Toast.LENGTH_SHORT).show();break;
                    case  R.id.nav_view:
                        Toast.makeText(MainActivity.this, "CLICKED TO VIEW", Toast.LENGTH_SHORT).show();break;
                    case  R.id.nav_manage:
                        Toast.makeText(MainActivity.this, "CLICKED TO MANAGE", Toast.LENGTH_SHORT).show();break;
                    default:
                        Toast.makeText(MainActivity.this, "CLICKED TO SLIDESHOW", Toast.LENGTH_SHORT).show();break;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else  {
            super.onBackPressed();
        }


    }


}