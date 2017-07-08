
package siddharth.com.fzrev.GsonData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gson {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("better_featured_image")
    @Expose
    private BetterFeaturedImage betterFeaturedImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public BetterFeaturedImage getBetterFeaturedImage() {
        return betterFeaturedImage;
    }

    public void setBetterFeaturedImage(BetterFeaturedImage betterFeaturedImage) {
        this.betterFeaturedImage = betterFeaturedImage;
    }

}
