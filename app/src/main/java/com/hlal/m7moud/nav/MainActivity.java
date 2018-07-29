package com.hlal.m7moud.nav;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hlal.m7moud.nav.Fragments.HomeFragment;
import com.hlal.m7moud.nav.Fragments.MyProfileFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer  ;
    NavigationView navigationView ;
    Button pressBack ;
    View header;
    Button buttonHide;

    LinearLayout LHome ;
    LinearLayout LProfile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer =findViewById(R.id.drawer);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawer , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
       drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = findViewById(R.id.nav_view);

        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                new HomeFragment()).commit() ;
        navigationView.setCheckedItem(R.id.home);
        }


        header=navigationView.getHeaderView(0);

        buttonHide=header.findViewById(R.id.BT_back);

        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ItemClick() ;


    }

    public void ItemClick(){

        LHome = header.findViewById(R.id.linHome);
        LHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                        new HomeFragment()).commit() ;
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        LProfile = header.findViewById(R.id.linProfile);
        LProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                        new MyProfileFragment()).commit() ;
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.home :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new HomeFragment()).commit() ;
               break;
           case R.id.profile :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new MyProfileFragment()).commit() ;
               break;
           case R.id.events :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new EventsFragment()).commit() ;
               break;
           case R.id.favories :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new FavoritesFragment()).commit() ;
               break;
           case R.id.inbox :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new InboxFragment()).commit() ;
               break;
           case R.id.contactUs :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new ContactUsFragment()).commit() ;
               break;
           case R.id.feedback :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new FeedBackFragment()).commit() ;
               break;
           case R.id.setting :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
                       new SettingsFragment()).commit() ;
               break;
       }

       drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
        super.onBackPressed();
        }
    }
}
