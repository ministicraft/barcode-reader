package ministicraft.android.barcodereader.isbndb.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ministicraft.android.barcodereader.R;
import ministicraft.android.barcodereader.googlebooks.Item;

public class ISBNdbHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;

    public ISBNdbHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }

    public void bind(Item book) {
        textView.setText(book.getVolumeInfo().getTitle());
        if (book.getVolumeInfo().getImageLinks() != null) {
            Picasso.get()
                    .load(book.getVolumeInfo().getImageLinks().getSmallThumbnail())
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.no_img)
                    .into(imageView);
        } else {
            Picasso.get()
                    .load(R.drawable.no_img)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.no_img)
                    .into(imageView);
        }
    }
}
