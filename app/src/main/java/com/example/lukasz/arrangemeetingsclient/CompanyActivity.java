package com.example.lukasz.arrangemeetingsclient;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.lukasz.arrangemeetingsclient.api.ApiResponse;
import com.example.lukasz.arrangemeetingsclient.api.Company;
import com.example.lukasz.arrangemeetingsclient.api.Metting;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.parceler.Parcels;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyActivity extends AppCompatActivity {

    @BindView(R.id.labelDate) TextView labelDate;
    @BindView(R.id.labelTimeFrom) TextView labelTimeFrom;
    @BindView(R.id.labelTimeTo) TextView labelTimeTo;

    @BindView(R.id.editTextFirstName) EditText editTextFirstName;
    @BindView(R.id.editTextLastName) EditText editTextLastName;
    @BindView(R.id.editTextPhone) EditText editTextPhone;
    @BindView(R.id.editTextMail) EditText editTextMail;

    public static Metting metting;

    Company company;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ButterKnife.bind(this);
        if (getIntent().hasExtra("company")) {
            company = Parcels.unwrap(getIntent().getParcelableExtra("company"));
            initView(company);
        } else {
            //textViewCompanyName.setText("Init error");
        }

    }

    private void initView(Company company) {
        setTitle(company.name);
        metting = new Metting();
        //    textViewCompanyName.setText(company.name);


    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            metting.setYear(year);
            metting.setMonth(month);
            metting.setDay(day);
            // Do something with the date chosen by the user

        }
    }

    public void showTimeFromPickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timeFrom");
    }

    public void showTimeToPickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timeTo");
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            switch (this.getTag()) {
                case "timeFrom": {
                    //Toast.makeText(getActivity(), "Time From", Toast.LENGTH_SHORT).show();
                   // TextView labelTimeFrom = view.findViewById(R.id.labelTimeFrom);
                   // labelTimeFrom.setText(hourOfDay + ":" + minute);
                    metting.setTimeFromHour(hourOfDay);
                    metting.setTimeFromMinute(minute);
                }
                break;
                case "timeTo": {
                    //Toast.makeText(getActivity(), "Time To", Toast.LENGTH_SHORT).show();
                    metting.setTimeToHour(hourOfDay);
                    metting.setTimeToMinute(minute);
                }
                break;
            }
        }
    }


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

    @OnClick(R.id.saveMetting)
    public void saveMetting() {
        metting.setPhone(editTextPhone.getText().toString());
        metting.setFirstName(editTextFirstName.getText().toString());
        metting.setLastName(editTextLastName.getText().toString());
        metting.setMail(editTextMail.getText().toString());
        metting.setCompanyID(company.id.intValue());

        ArrangeMeetings.apiInterface.saveMetting(metting).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() == null) {
                    Toast.makeText(CompanyActivity.this, "Niepowodzenie", Toast.LENGTH_SHORT).show();
                    return;
                }
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
