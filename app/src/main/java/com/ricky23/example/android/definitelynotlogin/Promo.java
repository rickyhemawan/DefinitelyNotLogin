package com.ricky23.example.android.definitelynotlogin;

public class Promo {
    private String promoTitle;
    private String promoDesc;
    private String price;
    private String promoImg;

    public Promo(String promoTitle, String promoDesc, String price, String promoImg) {
        this.promoTitle = promoTitle;
        this.promoDesc = promoDesc;
        this.price = price;
        this.promoImg = promoImg;
    }

    public String getPromoTitle() {
        return promoTitle;
    }

    public void setPromoTitle(String promoTitle) {
        this.promoTitle = promoTitle;
    }

    public String getPromoDesc() {
        return promoDesc;
    }

    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromoImg() {
        return promoImg;
    }

    public void setPromoImg(String promoImg) {
        this.promoImg = promoImg;
    }
}
