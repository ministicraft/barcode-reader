
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Tag {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Tag() {
    }

    /**
     * @param count
     * @param name
     */
    public Tag(Integer count, String name) {
        super();
        this.count = count;
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("name", name).toString();
    }

}
