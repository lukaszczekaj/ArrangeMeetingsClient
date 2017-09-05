package com.example.lukasz.arrangemeetingsclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.editTextApiUrl)
    EditText editTextApiUrl;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("com.example.lukasz.arrangemeetingsclient", MODE_PRIVATE);
    }

    @OnClick(R.id.buttonSaveSettings)
    public void onClickButtonSaveSettings() {
        sharedPreferences.edit().putString("setting.apiUrl", editTextApiUrl.getText().toString()).commit();
        Toast.makeText(this, "Zapisano", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getString("setting.apiUrl", "") != "") {
            editTextApiUrl.setText(sharedPreferences.getString("setting.apiUrl", null).toString());
        }

    }


}
