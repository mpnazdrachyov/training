package com.ub.training.index.services;

import com.ub.training.base.services.LayoutService;
import com.ub.training.index.views.IndexView;
import org.springframework.stereotype.Component;

@Component
public class IndexService extends LayoutService {

    public IndexView index() {
        IndexView indexView = new IndexView();
        this.fillLayout(indexView);
        indexView.setTab("tab");
      //  indexView.getSeoTags().setTitle("Главная");
        return indexView;
    }
}
