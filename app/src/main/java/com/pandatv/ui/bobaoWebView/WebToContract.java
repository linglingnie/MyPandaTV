package com.pandatv.ui.bobaoWebView;

import com.pandatv.base.IBaseView;
import com.pandatv.entity.bobaoBean.Web2Entity1;
import com.pandatv.entity.bobaoBean.Web2Entity2;
import com.pandatv.entity.bobaoBean.Web2Entity3;
import com.pandatv.modle.dataModel.bobaoModel.IBobaoPresenter;

/**
 * Created by ASUS on 2017/9/15.
 */

public interface WebToContract {

    public interface view extends IBaseView<presenter>{

        void ShowWeb2list1(Web2Entity1 list1);
        void ShowWeb2list2(Web2Entity2 list2);
        void ShowWeb2list3(Web2Entity3 list3);



    }

    interface presenter extends IBobaoPresenter{

    }
}
