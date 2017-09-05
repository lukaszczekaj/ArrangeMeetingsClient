package com.example.lukasz.arrangemeetingsclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lukasz.arrangemeetingsclient.api.Company;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {




    SharedPreferences sharedPreferences;
    public List<Company> allCompanyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.container, CompaniesFragment.getInstance(), "company_list");
            fragmentTransaction.commit();
        }
        sharedPreferences = getSharedPreferences("com.example.lukasz.arrangemeetingsclient", MODE_PRIVATE);



    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();


    }


    public void refresh() {
        ArrangeMeetings.apiInterface.getCompanyList().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String jsonString = response.body().toString();

                Type listType = new TypeToken<List<Company>>() {}.getType();
                List<Company> companyList = new Gson().fromJson(jsonString, listType);

                allCompanyList = companyList;
                CompaniesFragment company_list = (CompaniesFragment) getSupportFragmentManager().findFragmentByTag("company_list");

                company_list.adapterCompanies.companyList = companyList;
                company_list.adapterCompanies.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Pobrano dane z API", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e("onFailure", t.toString());
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onClickButtonSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }


    public void onClickCompanyItem(View view) {
        Toast.makeText(this, "Klik na company item", Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buttonMenuSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
