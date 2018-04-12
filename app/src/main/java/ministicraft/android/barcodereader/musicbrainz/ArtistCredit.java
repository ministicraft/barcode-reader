
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ArtistCredit {

    @SerializedName("artist")
    @Expose
    private Artist artist;

    /**
     * No args constructor for use in serialization
     */
    public ArtistCredit() {
    }

    /**
     * @param artist
     */
    public ArtistCredit(Artist artist) {
        super();
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("artist", artist).toString();
    }

}
