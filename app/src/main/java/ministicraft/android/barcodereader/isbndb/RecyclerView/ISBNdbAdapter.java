package ministicraft.android.barcodereader.isbndb.RecyclerView;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ministicraft.android.barcodereader.R;
import ministicraft.android.barcodereader.googlebooks.Item;

public class ISBNdbAdapter extends RecyclerView.Adapter<ISBNdbAdapter.ISBNdbHolder> {
    public List<Item> books;
    private ArrayList<Integer> selectedItems = new ArrayList<Integer>();
    private boolean multiSelect = false;
    private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            multiSelect = false;
            menu.add("Add");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            System.out.println(selectedItems);
            for (Integer intItem : selectedItems) {
                int index = intItem;
                System.out.println(index);
                System.out.println(books.get(index));
                //books.remove(index);
                new SendBook().execute(books.get(index));
            }
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            multiSelect = false;
            selectedItems.clear();
            notifyDataSetChanged();
        }
    };

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
        holder.bind(book, position);
    }

    @Override
    public int getItemCount() {
        if (books != null) {
            return books.size();
        } else return 0;
    }

    private class SendBook extends AsyncTask<Item, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Item... params) {
            Gson gson = new Gson();
            StringBuilder sb = null;
            BufferedReader reader = null;
            String serverResponse = null;
            try {
                URL url = new URL("http://192.168.10.5:3000/api/book");
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setRequestProperty("Content-Type", "application/json");
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("PUT");
                OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
                out.write(gson.toJson(params[0]));
                out.close();
                int statusCode = httpCon.getResponseCode();
                //Log.e("statusCode", "" + statusCode);
                if (statusCode == 200) {
                    sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                }

                httpCon.disconnect();
                if (sb != null)
                    serverResponse = sb.toString();
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
            System.out.println(s);
        }
    }

    class ISBNdbHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ISBNdbHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayout);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }

        void selectItem(Integer item) {
            if (!selectedItems.contains(item)) {
                selectedItems.clear();
                selectedItems.add(item);
            }
        }

        public void bind(final Item book, final Integer position) {
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
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    view.startActionMode(actionModeCallbacks);
                    selectItem(position);
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectItem(position);
                }
            });
        }
    }
}
