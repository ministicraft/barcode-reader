
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Release {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("packaging")
    @Expose
    private String packaging;
    @SerializedName("text-representation")
    @Expose
    private TextRepresentation textRepresentation;
    @SerializedName("artist-credit")
    @Expose
    private List<ArtistCredit> artistCredit = null;
    @SerializedName("release-group")
    @Expose
    private ReleaseGroup releaseGroup;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("release-events")
    @Expose
    private List<ReleaseEvent> releaseEvents = null;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("label-info")
    @Expose
    private List<LabelInfo> labelInfo = null;
    @SerializedName("track-count")
    @Expose
    private Integer trackCount;
    @SerializedName("media")
    @Expose
    private List<Medium> media = null;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;

    /**
     * No args constructor for use in serialization
     */
    public Release() {
    }

    /**
     * @param tags
     * @param asin
     * @param count
     * @param status
     * @param score
     * @param textRepresentation
     * @param barcode
     * @param artistCredit
     * @param date
     * @param releaseGroup
     * @param country
     * @param id
     * @param title
     * @param packaging
     * @param labelInfo
     * @param media
     * @param releaseEvents
     * @param trackCount
     */
    public Release(String id, String score, Integer count, String title, String status, String packaging, TextRepresentation textRepresentation, List<ArtistCredit> artistCredit, ReleaseGroup releaseGroup, String date, String country, List<ReleaseEvent> releaseEvents, String barcode, String asin, List<LabelInfo> labelInfo, Integer trackCount, List<Medium> media, List<Tag> tags) {
        super();
        this.id = id;
        this.score = score;
        this.count = count;
        this.title = title;
        this.status = status;
        this.packaging = packaging;
        this.textRepresentation = textRepresentation;
        this.artistCredit = artistCredit;
        this.releaseGroup = releaseGroup;
        this.date = date;
        this.country = country;
        this.releaseEvents = releaseEvents;
        this.barcode = barcode;
        this.asin = asin;
        this.labelInfo = labelInfo;
        this.trackCount = trackCount;
        this.media = media;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public TextRepresentation getTextRepresentation() {
        return textRepresentation;
    }

    public void setTextRepresentation(TextRepresentation textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    public List<ArtistCredit> getArtistCredit() {
        return artistCredit;
    }

    public void setArtistCredit(List<ArtistCredit> artistCredit) {
        this.artistCredit = artistCredit;
    }

    public ReleaseGroup getReleaseGroup() {
        return releaseGroup;
    }

    public void setReleaseGroup(ReleaseGroup releaseGroup) {
        this.releaseGroup = releaseGroup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ReleaseEvent> getReleaseEvents() {
        return releaseEvents;
    }

    public void setReleaseEvents(List<ReleaseEvent> releaseEvents) {
        this.releaseEvents = releaseEvents;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public List<LabelInfo> getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(List<LabelInfo> labelInfo) {
        this.labelInfo = labelInfo;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("score", score).append("count", count).append("title", title).append("status", status).append("packaging", packaging).append("textRepresentation", textRepresentation).append("artistCredit", artistCredit).append("releaseGroup", releaseGroup).append("date", date).append("country", country).append("releaseEvents", releaseEvents).append("barcode", barcode).append("asin", asin).append("labelInfo", labelInfo).append("trackCount", trackCount).append("media", media).append("tags", tags).toString();
    }

}
