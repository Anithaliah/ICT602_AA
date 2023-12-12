package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    Toolbar homepageToolbar;
    Button btnAbout;
    Button btnZakatCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        homepageToolbar = findViewById(R.id.homepage_toolbar);
        setSupportActionBar(homepageToolbar);
        getSupportActionBar().setTitle("Homepage");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initialize buttons
        btnAbout = findViewById(R.id.btnAbout);
        btnZakatCalculate = findViewById(R.id.btnZakCal);

        // Set OnClickListener for the About button
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the AboutActivity when the About button is clicked
                Intent aboutIntent = new Intent(Homepage.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });

        // Set OnClickListener for the Zakat Calculation button
        btnZakatCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the MainActivity when the Zakat Calculation button is clicked
                Intent zakatIntent = new Intent(Homepage.this, MainActivity.class);
                startActivity(zakatIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
