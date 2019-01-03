package lab1.sdmgap.edu.amarelaka;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String policeStation[] = {
            "Gulshan",
            "Mohakhali",
            "Banani",
            "Korail"
    };

    private final String policeStationNumber[] = {
            "01677006082",
            "01515209606",
            "01715533712",
            "01720278202"
    };

    private final String fireServiceNumber[] = {
            "01977006082",
            "01315209606",
            "01215533712",
            "01420278202"
    };

    private final String ward_image[] = {
            "https://vignette2.wikia.nocookie.net/peridot0/images/2/28/Pink_frosted_sprinkled_donut.png",
            "http://vignette4.wikia.nocookie.net/logopedia/images/d/d8/Andorid-2.3-Gingerbread-logo.png",
            "http://www.pngmart.com/files/4/Android-PNG-Photos.png",
            "http://goodereader.com/blog/uploads/images/android-froyo.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_home);

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                fragment = new home();
                break;
            case R.id.nav_gallery:
                fragment = new lab1.sdmgap.edu.amarelaka.Gallery();
                break;
            case R.id.nav_contact:
                fragment = new Contact();
                break;
            case R.id.mp_details:
                fragment = new Mp_Details();
                break;
            case R.id.nav_ward:

                fragment = new ward();

                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.wardRecycleView);
                recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList ward1 = prepareData();
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),ward1);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList prepareData(){
        ArrayList ward = new ArrayList<>();
        for(int i=0;i<policeStation.length;i++){
            WardDataModel wardDataModel = new WardDataModel();
            wardDataModel.setWard_police_station_name(policeStation[i]);
            wardDataModel.setWard_img(ward_image[i]);
            ward.add(wardDataModel);
        }
        return ward;
    }


}