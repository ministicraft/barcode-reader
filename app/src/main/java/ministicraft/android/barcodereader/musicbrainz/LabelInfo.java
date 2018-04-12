
package ministicraft.android.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LabelInfo {

    @SerializedName("catalog-number")
    @Expose
    private String catalogNumber;
    @SerializedName("label")
    @Expose
    private Label label;

    /**
     * No args constructor for use in serialization
     */
    public LabelInfo() {
    }

    /**
     * @param catalogNumber
     * @param label
     */
    public LabelInfo(String catalogNumber, Label label) {
        super();
        this.catalogNumber = catalogNumber;
        this.label = label;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("catalogNumber", catalogNumber).append("label", label).toString();
    }

}
