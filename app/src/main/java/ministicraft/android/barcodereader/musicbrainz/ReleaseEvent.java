
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReleaseEvent {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("area")
    @Expose
    private Area area;

    /**
     * No args constructor for use in serialization
     */
    public ReleaseEvent() {
    }

    /**
     * @param area
     * @param date
     */
    public ReleaseEvent(String date, Area area) {
        super();
        this.date = date;
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("date", date).append("area", area).toString();
    }

}
