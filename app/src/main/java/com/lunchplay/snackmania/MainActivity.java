package com.lunchplay.snackmania;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MyPageScreen myPageScreen = new MyPageScreen();
    private PopularPageScreen popularPageScreen = new PopularPageScreen();
    private SearchPageScreen searchPageScreen = new SearchPageScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.popular);
        fragmentManager.beginTransaction().replace(R.id.container, popularPageScreen).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId())
                {
                    case R.id.myPage:
                        transaction.replace(R.id.container, myPageScreen).commit();
                        break;
                    case R.id.popular:
                        transaction.replace(R.id.container, popularPageScreen).commit();
                        break;
                    case R.id.search:
                        transaction.replace(R.id.container, searchPageScreen).commit();
                        break;
                }

                return true;
            }
        });
    }
}