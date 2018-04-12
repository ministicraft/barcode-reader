package com.ministicraft.android.barcodereader;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ministicraft.android.barcodereader.isbndb.Book;
import com.ministicraft.android.barcodereader.isbndb.RecyclerView.ISBNdbAdapter;
import com.ministicraft.android.barcodereader.musicbrainz.MusicBrainzRelease;
import com.ministicraft.android.barcodereader.musicbrainz.RecyclerView.MusicBrainzAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnalyseActivity extends Activity {
    public static final String Barcode = "Barcode";
    private String barcode;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MusicBrainzAdapter());
        barcode = getIntent().getStringExtra(Barcode);
        if (validateIsbn13(barcode)) {
            new RetrieveBook().execute(barcode);
        } else {
            new RetrieveAlbum().execute(barcode);
        }

    }

    public boolean validateIsbn13(String isbn) {
        if (isbn == null) {
            return false;
        }

        //remove any hyphens
        isbn = isbn.replaceAll("-", "");

        //must be a 13 digit ISBN
        if (isbn.length() != 13) {
            return false;
        }

        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            //checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if (checksum == 10) {
                checksum = 0;
            }

            return checksum == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException nfe) {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
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

    private class RetrieveBook extends AsyncTask<String, Void, List<Book>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Book> doInBackground(String... params) {
            Book book = new Book(params[0]);
            List<Book> books = new ArrayList<Book>();
            try {

                Document doc;

                {
                    try {
                        doc = Jsoup.connect("https://isbndb.com/book/" + params[0]).get();
                        Element bookTtable = doc.getElementsByClass("book-table").first();
                        String title = bookTtable.child(0).child(0).child(0).child(1).text();
                        Element artwork = doc.getElementsByClass("artwork").first();
                        String artwork_url = artwork.child(0).attr("data");
                        book.setTitle(title);
                        book.setArtwork(artwork_url);
                        books.add(book);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {

            }
            return books;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            super.onPostExecute(books);
            mRecyclerView.setAdapter(new ISBNdbAdapter());
            ISBNdbAdapter ISBNdbAdapter = (ISBNdbAdapter) mRecyclerView.getAdapter();
            mRecyclerView.setAdapter(new ISBNdbAdapter(books));
        }
    }
}