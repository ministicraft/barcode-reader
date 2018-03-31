
package com.google.android.gms.samples.vision.barcodereader.musicbrainz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TextRepresentation {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("script")
    @Expose
    private String script;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TextRepresentation() {
    }

    /**
     * 
     * @param language
     * @param script
     */
    public TextRepresentation(String language, String script) {
        super();
        this.language = language;
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("language", language).append("script", script).toString();
    }

}
