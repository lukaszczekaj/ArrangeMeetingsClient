package com.example.lukasz.arrangemeetingsclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lukasz.arrangemeetingsclient.api.Company;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
