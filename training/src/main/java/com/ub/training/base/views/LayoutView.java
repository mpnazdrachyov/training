package com.ub.training.base.views;

import com.ub.core.seo.seoTags.models.SeoTags;

import java.util.Date;

public class LayoutView {
    public static final String MODEL_KEY = "layoutView";

    private SeoTags seoTags = new SeoTags();
    private Date currentDate;

    public SeoTags getSeoTags() {
        return seoTags;
    }

    public void setSeoTags(SeoTags seoTags) {
        this.seoTags = seoTags;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
