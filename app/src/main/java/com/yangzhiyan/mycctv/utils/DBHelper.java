package com.yangzhiyan.mycctv.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YZY on 2016/11/23.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DBNAME = "web.db";
    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table if not exists mycollect(" +
                "_id integer primary key autoincrement," +
                "itemType text," +
                "itemTitle text," +
                "detailUrl text," +
                "itemID text)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion<newVersion){
            db.execSQL("drop table mycollect");
            onCreate(db);
        }
    }
}
