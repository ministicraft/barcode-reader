
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReleaseGroup {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("primary-type")
    @Expose
    private String primaryType;

    /**
     * No args constructor for use in serialization
     */
    public ReleaseGroup() {
    }

    /**
     * @param id
     * @param primaryType
     */
    public ReleaseGroup(String id, String primaryType) {
        super();
        this.id = id;
        this.primaryType = primaryType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("primaryType", primaryType).toString();
    }

}
