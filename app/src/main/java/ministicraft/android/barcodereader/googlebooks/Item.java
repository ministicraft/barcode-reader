
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import ministicraft.android.barcodereader.isbndb.Book;

public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;
    @SerializedName("saleInfo")
    @Expose
    private SaleInfo saleInfo;
    @SerializedName("accessInfo")
    @Expose
    private AccessInfo accessInfo;
    @SerializedName("searchInfo")
    @Expose
    private SearchInfo searchInfo;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param saleInfo
     * @param id
     * @param searchInfo
     * @param etag
     * @param volumeInfo
     * @param selfLink
     * @param accessInfo
     * @param kind
     */
    public Item(String kind, String id, String etag, String selfLink, VolumeInfo volumeInfo, SaleInfo saleInfo, AccessInfo accessInfo, SearchInfo searchInfo) {
        super();
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
        this.searchInfo = searchInfo;
    }

    public Item(Book book) {
        this.volumeInfo = new VolumeInfo();
        volumeInfo.setTitle(book.getTitle());
        List<IndustryIdentifier> industryIdentifiers = new ArrayList<>();
        IndustryIdentifier identifier = new IndustryIdentifier("ISBN_13", book.getISBN());
        industryIdentifiers.add(identifier);
        volumeInfo.setIndustryIdentifiers(industryIdentifiers);
        ImageLinks imageLinks = new ImageLinks(book.getArtwork(), book.getArtwork());
        volumeInfo.setImageLinks(imageLinks);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("id", id).append("etag", etag).append("selfLink", selfLink).append("volumeInfo", volumeInfo).append("saleInfo", saleInfo).append("accessInfo", accessInfo).append("searchInfo", searchInfo).toString();
    }

}
