
package com.ministicraft.android.barcodereader.musicbrainz.Images;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Images {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("release")
    @Expose
    private String release;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    /**
     * 
     * @param images
     * @param release
     */
    public Images(List<Image> images, String release) {
        super();
        this.images = images;
        this.release = release;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("images", images).append("release", release).toString();
    }
    public static Images fromJson(String s){
        return new Gson().fromJson(s,Images.class);
    }

}
