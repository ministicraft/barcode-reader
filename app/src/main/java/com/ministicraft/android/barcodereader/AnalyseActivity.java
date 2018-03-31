package com.ministicraft.android.barcodereader;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ministicraft.android.barcodereader.musicbrainz.MusicBrainzRelease;
import com.ministicraft.android.barcodereader.musicbrainz.RecyclerView.MusicBrainzAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AnalyseActivity extends Activity {
    public static final String Barcode = "Barcode";
    private TextView barcodeValue;
    private String barcode;
    private RecyclerView mRecyclerView;
    private MusicBrainzAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MusicBrainzAdapter());
        barcode = getIntent().getStringExtra(Barcode);
        barcodeValue = (TextView)findViewById(R.id.barcode_value);

        //barcodeValue.setText(barcode);
        new RetrieveAlbum().execute(barcode);
    }

    private class RetrieveAlbum extends AsyncTask<String,Void,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder sb=null;
            BufferedReader reader=null;
            String serverResponse=null;
            try {

                URL url = new URL("http://musicbrainz.org/ws/2/release/?query=barcode:"+ params[0] +"&fmt=json");
                System.out.println(url.toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.connect();
                int statusCode = connection.getResponseCode();
                //Log.e("statusCode", "" + statusCode);
                if (statusCode == 200) {
                    sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                }

                connection.disconnect();
                if (sb!=null)
                    serverResponse=sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return serverResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //All your UI operation can be performed here
            //findViewById(R.id.progressBar).setVisibility(View.GONE);
            MusicBrainzRelease musicBrainzRelease = MusicBrainzRelease.fromJson(s);
            MusicBrainzAdapter musicBrainzAdapter = (MusicBrainzAdapter) mRecyclerView.getAdapter();
            mRecyclerView.setAdapter(new MusicBrainzAdapter(musicBrainzRelease.getReleases()));
            musicBrainzAdapter.notifyDataSetChanged();
        }
    }

}