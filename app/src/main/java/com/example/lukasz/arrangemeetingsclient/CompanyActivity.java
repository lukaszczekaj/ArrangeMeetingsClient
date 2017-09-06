package com.example.lukasz.arrangemeetingsclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lukasz.arrangemeetingsclient.api.ApiResponse;
import com.example.lukasz.arrangemeetingsclient.api.Company;
import com.example.lukasz.arrangemeetingsclient.api.Metting;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyActivity extends AppCompatActivity {

    @BindView(R.id.textViewCompanyName) TextView textViewCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ButterKnife.bind(this);
        if (getIntent().hasExtra("company")) {
            Company company = Parcels.unwrap(getIntent().getParcelableExtra("company"));
            initView(company);
        } else {
            textViewCompanyName.setText("Init error");
        }

    }

    private void initView(Company company) {
        setTitle(company.name);
        textViewCompanyName.setText(company.name);



    }

    @OnClick(R.id.saveMetting)
    public void getReceivingCustomersDates() {
        /**
         * TODO Do zrobienia pobieranie dat kiedy jest przyjmowanie klientów
         */
        ArrangeMeetings.apiInterface.getReceivingCustomersDate("1").enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                //   int statusCode = response.code();
                //   JsonArray user = response.body();
                Toast.makeText(CompanyActivity.this, "odpowiedz", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                // Log error here since request failed
                Toast.makeText(CompanyActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }



    public void saveMetting() {
        Metting metting = new Metting();
        metting.setMail("moj@mail.com");
    metting.setCompanyID(1);


        ArrangeMeetings.apiInterface.saveMetting(metting).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String jsonString = response.body().toString();
                ApiResponse r = new Gson().fromJson(jsonString, ApiResponse.class);
                Toast.makeText(CompanyActivity.this, r.message, Toast.LENGTH_SHORT).show();
                if (r.code == 200) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("onFailure", t.toString());
                Toast.makeText(CompanyActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
