package ece1778.asteria;

import android.os.Bundle;
import android.app.Activity;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.view.Menu;

public class Launch extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        StartingScreen fragStartscreen = new StartingScreen();  	
        	
    	android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction transaction = fm.beginTransaction();
    	transaction.replace(R.id.Screen_layout, fragStartscreen);   	
    	transaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launch, menu);
        return true;
    }
    
}
