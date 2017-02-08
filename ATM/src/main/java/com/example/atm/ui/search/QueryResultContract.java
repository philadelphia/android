package com.example.atm.ui.search;

import com.example.atm.base.BasePresenter;
import com.example.atm.base.BaseView;
import com.example.atm.bean.SiteItem;

import java.util.List;

/**
 * Created by Tao.ZT.Zhang on 2016/11/1.
 */

public interface QueryResultContract {
    //View
    public interface View extends BaseView<Presenter>{
        public void showQueryResult(List<SiteItem> siteList);

    }

    //Presenter
    public abstract class Presenter extends BasePresenter<View>{
        public abstract void QueryResult(String loginID, int productID, int circleID, int clusterID);

    }
}