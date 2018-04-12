
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class MusicBrainzRelease {

    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("releases")
    @Expose
    private List<Release> releases = null;

    /**
     * No args constructor for use in serialization
     */
    public MusicBrainzRelease() {
    }

    /**
     * @param count
     * @param created
     * @param releases
     * @param offset
     */
    public MusicBrainzRelease(String created, Integer count, Integer offset, List<Release> releases) {
        super();
        this.created = created;
        this.count = count;
        this.offset = offset;
        this.releases = releases;
    }

    public static MusicBrainzRelease fromJson(String s) {
        return new Gson().fromJson(s, MusicBrainzRelease.class);
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("created", created).append("count", count).append("offset", offset).append("releases", releases).toString();
    }

}
