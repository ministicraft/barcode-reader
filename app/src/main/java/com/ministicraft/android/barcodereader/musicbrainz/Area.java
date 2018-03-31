
package com.ministicraft.android.barcodereader.musicbrainz;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Area {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sort-name")
    @Expose
    private String sortName;
    @SerializedName("iso-3166-1-codes")
    @Expose
    private List<String> iso31661Codes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Area() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param iso31661Codes
     * @param sortName
     */
    public Area(String id, String name, String sortName, List<String> iso31661Codes) {
        super();
        this.id = id;
        this.name = name;
        this.sortName = sortName;
        this.iso31661Codes = iso31661Codes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public List<String> getIso31661Codes() {
        return iso31661Codes;
    }

    public void setIso31661Codes(List<String> iso31661Codes) {
        this.iso31661Codes = iso31661Codes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("sortName", sortName).append("iso31661Codes", iso31661Codes).toString();
    }

}
