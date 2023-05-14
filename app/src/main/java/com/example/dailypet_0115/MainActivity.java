package com.example.dailypet_0115;

import android.app.AlarmManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.TimeZone;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button remind;
    private ImageButton remind_imagebtn;
    private ImageButton health_imagebtn;
    private ImageButton shit_imagebtn;
    private ImageButton help_imagebtn;
    private ImageButton petinfo_imagebtn;
    private ImageButton logout_imagebtn;
    private ImageButton dogstep_imagebtn;
    private Button Post;

    private Button a;

    private FirebaseAuth mAuth;
    private DrawerLayout drawer;
    Calendar mCalendar;

    Toolbar toolbar;
    TabLayout tabLayout;
    PageAdapter pageAdapter;
    TabItem tabChat;
    TabItem tabStatus;
    TabItem tabCalls;
    private CircleImageView headimage;
    private FirebaseAuth firebaseAuth;
    private View navHeaderView;
    TextView tvHeaderName;
    String email;
    private FirebaseFirestore firebaseFirestore;
    private Uri ImageUri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startRemind();
       /* AlarmReceiver alarmReceiver =new AlarmReceiver(this);
        Notification notification=alarmReceiver.notification();*/


        a = findViewById(R.id.addheal);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View navHeaderView = navigationView.getHeaderView(0);

        TextView useremail = navHeaderView.findViewById(R.id.Email);
        useremail.setText(email);

        headimage = navHeaderView.findViewById(R.id.headimage);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("PetPicture").document(email).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                String image = task.getResult().getString("image");
                                ImageUri = Uri.parse(image);
                                try {
                                    Glide.with(MainActivity.this).load(image).into(headimage);
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(MainActivity.this, "Error: " + error, Toast.LENGTH_LONG).show();
                        }
                    }
                });

        //以下tabview
        //Toolbar toolbar_tab = findViewById(R.id.toolbar);

        /*View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.Email);
        navUsername.setText(eamil);*/


        //final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        final TabLayout tabLayout = findViewById(R.id.tablayout);
        TabItem tabChats = findViewById(R.id.tabChats);
        TabItem tabStatus = findViewById(R.id.tabStatus);
        TabItem tabCalls = findViewById(R.id.tabCalls);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    //toolbar.setBackgroundColor(ContextCompat.getColor(com.example.dailypet_0115.MainActivity.this,
                    // R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));
                    }
                } else if (tab.getPosition() == 2) {
                    //toolbar.setBackgroundColor(ContextCompat.getColor(com.example.dailypet_0115.MainActivity.this,
                    // android.R.color.darker_gray));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));
                    }
                } else {
                    // toolbar.setBackgroundColor(ContextCompat.getColor(com.example.dailypet_0115.MainActivity.this,
                    //    R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));
                    }
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //以上


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new dogstep_fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }
        */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent a1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(a1);


                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new remind_fragment()).commit();
                break;


            case R.id.nav_petinfo:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testfragment()).commit();

                Intent  a2= new Intent(MainActivity.this,createpet.class);
                startActivity(a2);
                break;

            case R.id.nav_remind:

                Intent a3 = new Intent(MainActivity.this, remind_new.class);
                startActivity(a3);
                break;


            case R.id.nav_help:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testfragment()).commit();
                Intent a4 = new Intent(MainActivity.this, firsttimepet.class);
                startActivity(a4);
                break;

            case R.id.nav_call:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testfragment()).commit();

                Intent  a6= new Intent(MainActivity.this,arduinoNo.class);
                startActivity(a6);
                break;

            case R.id.nav_wts_average:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testfragment()).commit();
                Intent a7 = new Intent(MainActivity.this, wts_average.class);
                startActivity(a7);
                break;

            case R.id.nav_logout:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testfragment()).commit();
                logOut();
                return true;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sendTologin() {
        Intent loginintent = new Intent(MainActivity.this, firstpage.class);
        startActivity(loginintent);
        finish();
    }

    private void logOut() {
        mAuth.getInstance().signOut();
        sendTologin();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void startRemind() {
        mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        long systemTime = System.currentTimeMillis();
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        mCalendar.set(Calendar.HOUR_OF_DAY, 13);
        mCalendar.set(Calendar.MINUTE, 30);
        mCalendar.set(Calendar.SECOND, 0);
        mCalendar.set(Calendar.MILLISECOND, 0);
        long selectTime = mCalendar.getTimeInMillis();
        if (systemTime > selectTime) {
            mCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 1, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), pi);

    }
}





