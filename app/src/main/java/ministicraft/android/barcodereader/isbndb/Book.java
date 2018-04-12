package ministicraft.android.barcodereader.isbndb;

public class Book {
    private String title;
    private String artwork;
    private String ISBN;

    public Book(String isbn) {
        this.ISBN = isbn;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }
}
