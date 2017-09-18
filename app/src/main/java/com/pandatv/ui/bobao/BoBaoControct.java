package com.pandatv.ui.bobao;

import com.pandatv.base.IBaseView;
import com.pandatv.entity.bobaoBean.BoBaoEntity1;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;
import com.pandatv.modle.dataModel.bobaoModel.IBobaoPresenter;

import java.util.List;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoControct {

    interface view extends IBaseView<presenters>{

        void showBoBaolist(BoBaoEntity1 boBaoEntity1);
        void shouBoBaolistto(List<BoBaoEntity2.ListBean> list);
    }



    interface presenters extends IBobaoPresenter{

    }

//    interface presenter  extends IBasePresenter {
//
//
//
//    }
}
