
package com.ministicraft.android.barcodereader.musicbrainz;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Artist {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sort-name")
    @Expose
    private String sortName;
    @SerializedName("aliases")
    @Expose
    private List<Alias> aliases = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param aliases
     * @param sortName
     */
    public Artist(String id, String name, String sortName, List<Alias> aliases) {
        super();
        this.id = id;
        this.name = name;
        this.sortName = sortName;
        this.aliases = aliases;
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

    public List<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("sortName", sortName).append("aliases", aliases).toString();
    }

}
