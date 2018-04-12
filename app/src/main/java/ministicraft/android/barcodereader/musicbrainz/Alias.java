
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Alias {

    @SerializedName("sort-name")
    @Expose
    private String sortName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("locale")
    @Expose
    private Object locale;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("primary")
    @Expose
    private Object primary;
    @SerializedName("begin-date")
    @Expose
    private Object beginDate;
    @SerializedName("end-date")
    @Expose
    private Object endDate;

    /**
     * No args constructor for use in serialization
     */
    public Alias() {
    }

    /**
     * @param primary
     * @param locale
     * @param name
     * @param endDate
     * @param beginDate
     * @param type
     * @param sortName
     */
    public Alias(String sortName, String name, Object locale, Object type, Object primary, Object beginDate, Object endDate) {
        super();
        this.sortName = sortName;
        this.name = name;
        this.locale = locale;
        this.type = type;
        this.primary = primary;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLocale() {
        return locale;
    }

    public void setLocale(Object locale) {
        this.locale = locale;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getPrimary() {
        return primary;
    }

    public void setPrimary(Object primary) {
        this.primary = primary;
    }

    public Object getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Object beginDate) {
        this.beginDate = beginDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sortName", sortName).append("name", name).append("locale", locale).append("type", type).append("primary", primary).append("beginDate", beginDate).append("endDate", endDate).toString();
    }

}
