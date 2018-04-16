
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Book {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    /**
     * No args constructor for use in serialization
     */
    public Book() {
    }

    /**
     * @param items
     * @param totalItems
     * @param kind
     */
    public Book(String kind, Integer totalItems, List<Item> items) {
        super();
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public Book(ministicraft.android.barcodereader.isbndb.Book book) {
        this.kind = "books#volumes";
        this.totalItems = 1;
        Item item = new Item(book);
        this.items = new ArrayList<>();
        items.add(item);
    }

    public static Book fromJson(String s) {
        return new Gson().fromJson(s, Book.class);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("totalItems", totalItems).append("items", items).toString();
    }

}
