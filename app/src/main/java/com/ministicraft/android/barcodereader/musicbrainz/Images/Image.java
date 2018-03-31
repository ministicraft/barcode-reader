
package com.ministicraft.android.barcodereader.musicbrainz.Images;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Image {

    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("back")
    @Expose
    private Boolean back;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("edit")
    @Expose
    private Integer edit;
    @SerializedName("front")
    @Expose
    private Boolean front;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;
    @SerializedName("types")
    @Expose
    private List<String> types = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param id
     * @param approved
     * @param edit
     * @param image
     * @param back
     * @param front
     * @param thumbnails
     * @param types
     * @param comment
     */
    public Image(Boolean approved, Boolean back, String comment, Integer edit, Boolean front, Integer id, String image, Thumbnails thumbnails, List<String> types) {
        super();
        this.approved = approved;
        this.back = back;
        this.comment = comment;
        this.edit = edit;
        this.front = front;
        this.id = id;
        this.image = image;
        this.thumbnails = thumbnails;
        this.types = types;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getBack() {
        return back;
    }

    public void setBack(Boolean back) {
        this.back = back;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEdit() {
        return edit;
    }

    public void setEdit(Integer edit) {
        this.edit = edit;
    }

    public Boolean getFront() {
        return front;
    }

    public void setFront(Boolean front) {
        this.front = front;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("approved", approved).append("back", back).append("comment", comment).append("edit", edit).append("front", front).append("id", id).append("image", image).append("thumbnails", thumbnails).append("types", types).toString();
    }

}
