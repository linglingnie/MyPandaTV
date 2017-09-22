package com.pandatv.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Yuan on 2017/9/22.
 */

public class DaoManger {
    private static DaoManger manger;
    private static final String DB_NAME = "user.db";
    private  DaoMaster.DevOpenHelper helper;

    private DaoManger(Context context) {

        helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
    }

    public static DaoManger getInstance(Context context) {
        if (manger == null) {
            synchronized (DaoManger.class) {
                if (manger == null) {

                    manger = new DaoManger(context);
                }
            }
        }
        return manger;
    }

    public SQLiteDatabase reader(){

        return helper.getReadableDatabase();
    }

    public SQLiteDatabase write(){

        return helper.getWritableDatabase();
    }

    public UserBeanDao getDao(){

        return  new DaoMaster(write()).newSession().getUserBeanDao();
    }
}
