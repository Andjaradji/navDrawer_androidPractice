package com.rds.andjaradji.drawerconstruction;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private static final String DEBUG_TAG = "Andjar Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayoutID);

       mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,mToolbar, R.string.openDrawer, R.string.closeDrawer){
            public void onDrawerOpened (View view){
                super.onDrawerOpened(view);
            }

            public void onDrawerClosed (View view){
                super.onDrawerClosed(view);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mToolbar = (Toolbar)findViewById(R.id.toolbarID);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = findViewById(R.id.navigationViewID);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.navDramaID:
                        Log.d(DEBUG_TAG,getResources().getString(R.string.drama));
                        return true;
                    case R.id.navFilmID:
                        Log.d(DEBUG_TAG,getResources().getString(R.string.film));
                        return true;
                    case R.id.navSportID:
                        Log.d(DEBUG_TAG,getResources().getString(R.string.sport));
                        return true;
                    case R.id.navNewsNationalID:
                        Log.d(DEBUG_TAG,getResources().getString(R.string.national));
                        return true;
                    case R.id.navNewsInternationalID:
                        Log.d(DEBUG_TAG,getResources().getString(R.string.international));
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
