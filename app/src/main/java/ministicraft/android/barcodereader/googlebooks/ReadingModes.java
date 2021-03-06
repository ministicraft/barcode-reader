
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReadingModes {

    @SerializedName("text")
    @Expose
    private Boolean text;
    @SerializedName("image")
    @Expose
    private Boolean image;

    /**
     * No args constructor for use in serialization
     */
    public ReadingModes() {
    }

    /**
     * @param text
     * @param image
     */
    public ReadingModes(Boolean text, Boolean image) {
        super();
        this.text = text;
        this.image = image;
    }

    public Boolean getText() {
        return text;
    }

    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("text", text).append("image", image).toString();
    }

}
