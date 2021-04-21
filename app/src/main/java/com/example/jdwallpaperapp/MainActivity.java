        package com.example.jdwallpaperapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {


            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list = new ArrayList<>();
        list.add(new Custom_Items("https://images.pexels.com/photos/370717/pexels-photo-370717.jpeg?cs=srgb&dl=pexels-andre-furtado-370717.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1083822/pexels-photo-1083822.jpeg?cs=srgb&dl=pexels-lisa-fotios-1083822.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?cs=srgb&dl=pexels-pixabay-36717.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/769525/pexels-photo-769525.jpeg?cs=srgb&dl=pexels-rakicevic-nenad-769525.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1342650/pexels-photo-1342650.jpeg?cs=srgb&dl=pexels-olegbf-oleg-borisov-1342650.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/568785/pexels-photo-568785.jpeg?cs=srgb&dl=pexels-justin-568785.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/3217852/pexels-photo-3217852.jpeg?cs=srgb&dl=pexels-jonathan-borba-3217852.jpg&fm=jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images-na.ssl-images-amazon.com/images/I/81A%2BqqYaYFL._SX355_.jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1236701/pexels-photo-1236701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://wallpapershome.com/images/wallpapers/lake-aurora-1080x1920-4k-hd-wallpaper-florida-night-sky-stars-12771.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/1204217.jpg"));
        list.add(new Custom_Items("https://eskipaper.com/images/nature-wallpapers-8.jpg"));
        list.add(new Custom_Items("https://wallpapers.pictures/media/nature-background-wallpaper-20161022222031-1080x1920.jpg"));
        list.add(new Custom_Items("https://img.wallpapersafari.com/tablet/768/1024/72/89/pvoZel.jpg"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/f1/6b/ee/f16beeac4b5355487a3265c3d1b62c65.jpg"));
        list.add(new Custom_Items("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSlUYybSZWe45G7GvR8Kj96DphdOv7lJhaBGQ&usqp=CAU"));
        list.add(new Custom_Items("https://www.lefthudson.com/wp-content/uploads/2019/11/blue-wallpaper-iphone-6-beautiful-70-beautiful-nature-amp-landscape-iphone-6-wallpaper-free-to-download-this-week-of-blue-wallpaper-iphone-6.jpg"));
        list.add(new Custom_Items("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3e84f3a5-b15a-4a8f-a69f-1df301724560/da1qb0w-9ca9c09c-7059-480f-8272-c96f3c65fe33.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvM2U4NGYzYTUtYjE1YS00YThmLWE2OWYtMWRmMzAxNzI0NTYwXC9kYTFxYjB3LTljYTljMDljLTcwNTktNDgwZi04MjcyLWM5NmYzYzY1ZmUzMy5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.p-MDB99Sbf34G1xNCks1SK09dqdItIOV8yKckp7d9kU"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/d5/5b/3a/d55b3a0130f2507fc9bf0d977d240304.jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://www.itl.cat/pngfile/big/35-357728_download-wallpaper-love-nature-wallpaper-hd-for-mobile.jpg"));
        list.add(new Custom_Items(""));
        getdata();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {

                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        } else if (id == R.id.Settings) {

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.rate_us) {
            //rateme();


            //MoreApp();
        }
        


        else if (id == R.id.llprivacypolicy) {


        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + "Account Name!")));


        }
    }




    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


}