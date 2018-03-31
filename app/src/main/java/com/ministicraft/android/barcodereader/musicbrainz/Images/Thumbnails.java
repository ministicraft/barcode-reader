
package com.ministicraft.android.barcodereader.musicbrainz.Images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Thumbnails {

    @SerializedName("250")
    @Expose
    private String _250;
    @SerializedName("500")
    @Expose
    private String _500;
    @SerializedName("1200")
    @Expose
    private String _1200;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("small")
    @Expose
    private String small;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnails() {
    }

    /**
     * 
     * @param _250
     * @param _1200
     * @param small
     * @param large
     * @param _500
     */
    public Thumbnails(String _250, String _500, String _1200, String large, String small) {
        super();
        this._250 = _250;
        this._500 = _500;
        this._1200 = _1200;
        this.large = large;
        this.small = small;
    }

    public String get250() {
        return _250;
    }

    public void set250(String _250) {
        this._250 = _250;
    }

    public String get500() {
        return _500;
    }

    public void set500(String _500) {
        this._500 = _500;
    }

    public String get1200() {
        return _1200;
    }

    public void set1200(String _1200) {
        this._1200 = _1200;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_250", _250).append("_500", _500).append("_1200", _1200).append("large", large).append("small", small).toString();
    }

}
