package com.example.lukasz.arrangemeetingsclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukasz.arrangemeetingsclient.api.Company;

import java.io.InputStream;
import java.net.URL;
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
        holder.textViewInformation.setText(companyList.get(position).addressstreet.toString() + ", "
                + companyList.get(position).addresscity.toString());

        new DownLoadImageTask(holder.imageView).execute(companyList.get(position).imgurl.toString());
     //   holder.imageView.setMaxHeight(1);
      //  holder.imageView.setMaxWidth(5);
    }



    @Override
    public int getItemCount() {
        return companyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewContent;
        public TextView textViewInformation;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewContent = itemView.findViewById(R.id.content);
            textViewInformation = itemView.findViewById(R.id.information);
            imageView = itemView.findViewById(R.id.photo);
        }
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }

}
