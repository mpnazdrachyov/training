package com.ub.training.base.services;

import com.ub.training.base.views.LayoutView;

import java.util.Date;

public class LayoutService {

    protected <T extends LayoutView> T fillLayout(T layoutView) {
        layoutView.setCurrentDate(new Date());
        return layoutView;
    }
}
