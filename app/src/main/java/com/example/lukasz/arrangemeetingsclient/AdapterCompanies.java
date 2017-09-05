package com.example.lukasz.arrangemeetingsclient;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lukasz.arrangemeetingsclient.api.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 04.09.17.
 */

public class AdapterCompanies extends RecyclerView.Adapter<AdapterCompanies.ViewHolder> {

    List<Company> companyList = new ArrayList<>();

    public AdapterCompanies(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        AdapterCompanies.ViewHolder vh = new ViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewContent.setText(companyList.get(position).name.toString());
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewContent;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewContent = itemView.findViewById(R.id.content);
        }
    }

}
