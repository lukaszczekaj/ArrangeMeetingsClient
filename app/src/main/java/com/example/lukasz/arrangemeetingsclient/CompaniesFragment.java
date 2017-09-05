package com.example.lukasz.arrangemeetingsclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompaniesFragment extends Fragment {

    RecyclerView recyclerView;
    public AdapterCompanies adapterCompanies;


    public CompaniesFragment() {
        // Required empty public constructor
    }

    public static CompaniesFragment getInstance() {
        return new CompaniesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_companies, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapterCompanies = new AdapterCompanies( ((MainActivity) getActivity()).allCompanyList );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterCompanies);
        recyclerView.setHasFixedSize(true);
        return view;
    }

}
