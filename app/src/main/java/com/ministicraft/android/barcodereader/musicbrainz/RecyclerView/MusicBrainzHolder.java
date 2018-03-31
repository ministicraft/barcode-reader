package com.ministicraft.android.barcodereader.musicbrainz.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ministicraft.android.barcodereader.R;
import com.ministicraft.android.barcodereader.musicbrainz.Release;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class MusicBrainzHolder extends RecyclerView.ViewHolder{

    public TextView textView;
    public ImageView imageView;

    public MusicBrainzHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }
    public void bind(Release release){
        textView.setText(release.getArtistCredit().get(0).getArtist().getName() + " - " +release.getTitle());
        Picasso.get()
                .load("http://coverartarchive.org/release/"+ release.getId()+"/front/250")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.no_img)
                .into(imageView);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            if (result!=null) {
                bmImage.setImageBitmap(result);
            }else{
                bmImage.setImageResource(R.drawable.icon);
            }
        }
    }
}
