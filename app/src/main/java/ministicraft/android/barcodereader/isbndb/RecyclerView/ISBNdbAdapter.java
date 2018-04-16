package ministicraft.android.barcodereader.isbndb.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ministicraft.android.barcodereader.R;
import ministicraft.android.barcodereader.googlebooks.Item;

public class ISBNdbAdapter extends RecyclerView.Adapter<ISBNdbHolder> {
    public List<Item> books;

    public ISBNdbAdapter(List<Item> books) {
        this.books = books;
    }

    public ISBNdbAdapter() {
        this.books = null;
    }

    @Override
    public ISBNdbHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_cards, parent, false);
        return new ISBNdbHolder(view);
    }

    @Override
    public void onBindViewHolder(ISBNdbHolder holder, int position) {
        Item book = books.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        if (books != null) {
            return books.size();
        } else return 0;
    }
}
