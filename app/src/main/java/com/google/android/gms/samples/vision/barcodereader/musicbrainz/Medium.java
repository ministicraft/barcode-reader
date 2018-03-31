
package com.google.android.gms.samples.vision.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Medium {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("disc-count")
    @Expose
    private Integer discCount;
    @SerializedName("track-count")
    @Expose
    private Integer trackCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param discCount
     * @param format
     * @param trackCount
     */
    public Medium(String format, Integer discCount, Integer trackCount) {
        super();
        this.format = format;
        this.discCount = discCount;
        this.trackCount = trackCount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getDiscCount() {
        return discCount;
    }

    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("format", format).append("discCount", discCount).append("trackCount", trackCount).toString();
    }

}
