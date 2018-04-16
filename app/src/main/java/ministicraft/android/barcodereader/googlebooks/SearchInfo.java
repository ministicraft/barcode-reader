
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SearchInfo {

    @SerializedName("textSnippet")
    @Expose
    private String textSnippet;

    /**
     * No args constructor for use in serialization
     */
    public SearchInfo() {
    }

    /**
     * @param textSnippet
     */
    public SearchInfo(String textSnippet) {
        super();
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("textSnippet", textSnippet).toString();
    }

}
