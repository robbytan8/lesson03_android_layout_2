package com.robby.lesson03_android_layout_2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtFirstName)
    EditText txtFirstName;
    @BindView(R.id.txtLastName)
    EditText txtLastName;
    @BindView(R.id.txtAddress)
    EditText txtAddress;
    @BindView(R.id.spinCity)
    Spinner spinCity;

    private List<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.populateCityData();
        ArrayAdapter<String> adapterCities = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, getCities());
        spinCity.setAdapter(adapterCities);
    }

    @OnClick(R.id.btnSubmit)
    public void submitData() {
        if (TextUtils.isEmpty(txtFirstName.getText().toString().trim()) ||
                TextUtils.isEmpty(txtLastName.getText().toString().trim()) ||
                spinCity.getSelectedItem() == null) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Error");
            alertBuilder.setMessage("Please fill first and last name");
            alertBuilder.setPositiveButton("OK", null);
            alertBuilder.show();
        } else {
            Toast.makeText(this, "Data submitted", Toast.LENGTH_SHORT).show();
            txtFirstName.setText("");
            txtLastName.setText("");
            txtAddress.setText("");
        }
    }

    private void populateCityData() {
        this.getCities().add("Bandung");
        this.getCities().add("Jakarta");
        this.getCities().add("Surabaya");
        this.getCities().add("Yogyakarta");
        this.getCities().add("Semarang");
        this.getCities().add("Malang");
    }

    public List<String> getCities() {
        if (cities == null) {
            cities = new ArrayList<>();
        }
        return cities;
    }
}
