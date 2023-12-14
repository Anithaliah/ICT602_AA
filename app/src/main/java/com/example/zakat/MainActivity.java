package com.example.zakat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etWeight;
    EditText etPrice;
    Button btnConvert;
    TextView tvWeight;
    TextView tvPrice;
    TextView tvTotalGold;
    RadioButton rbKeep;
    RadioButton rbWear;

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.editTextWeight);
        etPrice = findViewById(R.id.editTextPrice);
        btnConvert = findViewById(R.id.btnZakCal);
        tvWeight = findViewById(R.id.tvWeight);
        tvPrice = findViewById(R.id.tvPrice);
        tvTotalGold = findViewById(R.id.tvTotalGold);
        rbKeep = findViewById(R.id.rbKeep);
        rbWear = findViewById(R.id.rbWear);

        btnConvert.setOnClickListener(this);

        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Please use my application - https://github.com/Anithaliah/ICT602_AA");
            startActivity(Intent.createChooser(shareIntent, null));
            return true;
        } else if (item.getItemId() == R.id.item_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        } else if (item.getItemId() == R.id.item_homepage) {
            Intent aboutIntent = new Intent(this, Homepage.class);
            startActivity(aboutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnZakCal) {
            try {
                if (etWeight.getText().toString().isEmpty() || etPrice.getText().toString().isEmpty()) {
                    showMessage("Please enter both weight and price.");
                    return;
                }

                double weight = Double.parseDouble(etWeight.getText().toString());
                double price = Double.parseDouble(etPrice.getText().toString());
                double total = 0;

                if (!rbKeep.isChecked() && !rbWear.isChecked()) {
                    showMessage("Please choose the type of gold (Keep or Wear).");
                    return;
                }

                if (rbKeep.isChecked()) {
                    total = weight - 85;
                } else if (rbWear.isChecked()) {
                    total = weight - 200;
                }

                double totalGold = total * price;
                double totalZakat = totalGold * 0.025;

                if (totalGold <= 0) {
                    totalGold = 0;
                    totalZakat = 0;
                }

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedTotal = decimalFormat.format(total);
                String formattedTotalGold = decimalFormat.format(totalGold);
                String formattedTotalZakat = decimalFormat.format(totalZakat);

                tvWeight.setText(formattedTotal);
                tvTotalGold.setText(formattedTotalGold);
                tvPrice.setText(formattedTotalZakat);

            } catch (NumberFormatException e) {
                showMessage("Please enter valid numeric values for weight and price.");
            }
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
