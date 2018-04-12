package com.ministicraft.android.barcodereader.isbndb.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ministicraft.android.barcodereader.R;
import com.ministicraft.android.barcodereader.isbndb.Book;
import com.squareup.picasso.Picasso;

public class ISBNdbHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;

    public ISBNdbHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }

    public void bind(Book book) {
        textView.setText(book.getTitle());
        Picasso.get()
                .load(book.getArtwork())
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.no_img)
                .into(imageView);
    }
}
