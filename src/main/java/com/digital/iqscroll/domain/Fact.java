package com.digital.iqscroll.domain;

public class Fact {
    private String factId;
    private String factImageUrl;
    private String factBodyText;

    public Fact(String factId, String factImageUrl, String factBodyText) {
        this.factId = factId;
        this.factImageUrl = factImageUrl;
        this.factBodyText = factBodyText;
    }

    public String getFactId() {
        return this.factId;
    }

    public String getFactImageUrl() {
        return this.factImageUrl;
    }

    public String getFactBodyText() {
        return this.factBodyText;
    }

    public void setFactId(String factId) {
        this.factId = factId;
    }

    public void setFactImageUrl(String factImageUrl) {
        this.factImageUrl = factImageUrl;
    }

    public void setFactBodyText(String factBodyText) {
        this.factBodyText = factBodyText;
    }
}
