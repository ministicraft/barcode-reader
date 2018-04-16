
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Epub {

    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("acsTokenLink")
    @Expose
    private String acsTokenLink;

    /**
     * No args constructor for use in serialization
     */
    public Epub() {
    }

    /**
     * @param acsTokenLink
     * @param isAvailable
     */
    public Epub(Boolean isAvailable, String acsTokenLink) {
        super();
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isAvailable", isAvailable).append("acsTokenLink", acsTokenLink).toString();
    }

}
