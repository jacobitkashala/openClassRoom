package com.example.openclassroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewOC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 - Configuring Toolbar
        /*
        * une methode qui permet de faire la configuration
        */
        this.configureToolbar();
        //2 - Serialise & confige imageView
        this.configureImageView();
    }



    private void configureImageView(){
        // Serialise ImageView
        this.imageViewOC = (ImageView) this.findViewById(R.id.imageView);
        // Set OnClick Listener on it
        imageViewOC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Launch Detail Activity
                launchDetailActivity();
            }
        });
    }

    // ----

    private void launchDetailActivity(){
        Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
        this.startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 - Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                Toast.makeText(this, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_main_search:
                Toast.makeText(this, "Recherche indisponible, demandez plutôt l'avis de Google, c'est mieux et plus rapide.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}