package domain.model;

public class CommerceItem {
    private final String title;
    private final Platform platform;
    private final String thumbnail;
    private final Integer originalPrice;
    private final Integer sellingPrice;
    private final Double discountRate;

    private CommerceItem() {
        this(null, null, null, null, null, null);
    }

    public CommerceItem(String title, Platform platform, String thumbnail, Integer originalPrice, Integer sellingPrice, Double discountRate) {
        this.title = title;
        this.platform = platform;
        this.thumbnail = thumbnail;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
        this.discountRate = discountRate;
    }

    public String getTitle() {
        return title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public Double getDiscountRate() {
        return discountRate;
    }
}
