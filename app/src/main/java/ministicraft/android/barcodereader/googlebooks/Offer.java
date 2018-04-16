
package ministicraft.android.barcodereader.googlebooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Offer {

    @SerializedName("finskyOfferType")
    @Expose
    private Integer finskyOfferType;
    @SerializedName("listPrice")
    @Expose
    private ListPrice_ listPrice;
    @SerializedName("retailPrice")
    @Expose
    private RetailPrice_ retailPrice;
    @SerializedName("giftable")
    @Expose
    private Boolean giftable;

    /**
     * No args constructor for use in serialization
     */
    public Offer() {
    }

    /**
     * @param retailPrice
     * @param listPrice
     * @param finskyOfferType
     * @param giftable
     */
    public Offer(Integer finskyOfferType, ListPrice_ listPrice, RetailPrice_ retailPrice, Boolean giftable) {
        super();
        this.finskyOfferType = finskyOfferType;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
        this.giftable = giftable;
    }

    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice_ getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Boolean getGiftable() {
        return giftable;
    }

    public void setGiftable(Boolean giftable) {
        this.giftable = giftable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("finskyOfferType", finskyOfferType).append("listPrice", listPrice).append("retailPrice", retailPrice).append("giftable", giftable).toString();
    }

}
