package ministicraft.android.barcodereader.musicbrainz.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ministicraft.android.barcodereader.R;
import ministicraft.android.barcodereader.musicbrainz.Release;

public class MusicBrainzHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;

    public MusicBrainzHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }

    public void bind(Release release) {
        textView.setText(release.getArtistCredit().get(0).getArtist().getName() + " - " + release.getTitle());
        Picasso.get()
                .load("http://coverartarchive.org/release/" + release.getId() + "/front/250")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.no_img)
                .into(imageView);
    }
}
