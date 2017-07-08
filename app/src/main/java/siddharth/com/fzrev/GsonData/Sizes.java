
package siddharth.com.fzrev.GsonData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("widget")
    @Expose
    private Widget widget;
    @SerializedName("square")
    @Expose
    private Square square;
    @SerializedName("portfolio_small")
    @Expose
    private PortfolioSmall portfolioSmall;
    @SerializedName("shop_thumbnail")
    @Expose
    private ShopThumbnail shopThumbnail;
    @SerializedName("shop_catalog")
    @Expose
    private ShopCatalog shopCatalog;
    @SerializedName("shop_single")
    @Expose
    private ShopSingle shopSingle;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public PortfolioSmall getPortfolioSmall() {
        return portfolioSmall;
    }

    public void setPortfolioSmall(PortfolioSmall portfolioSmall) {
        this.portfolioSmall = portfolioSmall;
    }

    public ShopThumbnail getShopThumbnail() {
        return shopThumbnail;
    }

    public void setShopThumbnail(ShopThumbnail shopThumbnail) {
        this.shopThumbnail = shopThumbnail;
    }

    public ShopCatalog getShopCatalog() {
        return shopCatalog;
    }

    public void setShopCatalog(ShopCatalog shopCatalog) {
        this.shopCatalog = shopCatalog;
    }

    public ShopSingle getShopSingle() {
        return shopSingle;
    }

    public void setShopSingle(ShopSingle shopSingle) {
        this.shopSingle = shopSingle;
    }

}
