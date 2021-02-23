package com.ktpt.commerssg.common.domain.model;

import java.util.Map;

public class CommerceItem {
    private final String title;
    private final Platform platform;
    private final String thumbnail;
    private final Integer originalPrice;
    private final Integer sellingPrice;
    private final Double discountRate;
    // TODO: 2021/02/23 url, startDate, onLive?
//    private final String liveUrl;
//    private final String replayUrl;

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

    public static CommerceItem naverOf(Map<String, String> items) {
        String title = items.get("broadcastTitle");
        Platform platform = Platform.NAVER;
        String thumbnail = items.get("broadcastStandByImage");
        // TODO: 2021/02/23 json check
//        String displayProduct = items.get("displayProduct");
        return new CommerceItem(title, platform, thumbnail, null, null, null);
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
