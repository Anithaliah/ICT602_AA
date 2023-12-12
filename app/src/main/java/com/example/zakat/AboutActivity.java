package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    Toolbar aboutToolbar;
    TextView tvGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("About");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvGitHub = findViewById(R.id.tvGithub);

        // Use Html.fromHtml to format the text with HTML tags
        String githubLink = "<a href='https://github.com/Anithaliah/ICT602_AA'>MyGitHub</a>";
        tvGitHub.setText(Html.fromHtml("Github: " + githubLink));

        // Make the link clickable
        tvGitHub.setMovementMethod(LinkMovementMethod.getInstance());

        tvGitHub.setOnClickListener(v -> {
            // Open the link in a web browser
            Uri uri = Uri.parse("https://github.com/Anithaliah/ICT602_AA");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
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
