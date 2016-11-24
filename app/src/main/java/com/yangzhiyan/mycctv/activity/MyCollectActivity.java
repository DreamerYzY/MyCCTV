package com.yangzhiyan.mycctv.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.CollectListAdapter;
import com.yangzhiyan.mycctv.utils.DBHelper;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollectActivity extends AppCompatActivity {
    @ViewInject(R.id.collect_list)
    ListView collevt_list;
    @ViewInject(R.id.item_return)
    ImageView item_return;

    private SQLiteDatabase sd;
    private DBHelper helper;

    private List<Map<String,String>> datalist;
    private CollectListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        x.view().inject(this);

        helper = new DBHelper(this);
        datalist = new ArrayList<>();

        collevt_list.setEmptyView(findViewById(R.id.list_empty));

        sd = helper.getReadableDatabase();
        Cursor cursor = sd.query("mycollect",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Map<String,String> map = new HashMap<>();
            map.put("itemTitle",cursor.getString(cursor.getColumnIndex("itemTitle")));
            map.put("detailUrl",cursor.getString(cursor.getColumnIndex("detailUrl")));
            map.put("itemID",cursor.getString(cursor.getColumnIndex("itemID")));
            map.put("itemType",cursor.getString(cursor.getColumnIndex("itemType")));
            datalist.add(map);
        }
        cursor.close();
        adapter = new CollectListAdapter(this,datalist);
        collevt_list.setAdapter(adapter);

        collevt_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MyCollectActivity.this,FocusItemArticleActivity.class);
                intent.putExtra("itemType",datalist.get(position).get("itemType"));
                intent.putExtra("itemID",datalist.get(position).get("itemID"));
                intent.putExtra("detailUrl",datalist.get(position).get("detailUrl"));
                startActivity(intent);
            }
        });
        collevt_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog = new AlertDialog.Builder(MyCollectActivity.this)
                        .setTitle("删除本条收藏？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sd = helper.getReadableDatabase();
                                int a = sd.delete("mycollect","itemID=?",
                                        new String[]{datalist.get(position).get("itemID")});
                                if (a>0){
                                    datalist.remove(position);
                                    adapter.notifyDataSetChanged();
                                }
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                dialog.show();
                return true;
            }
        });

        item_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCollectActivity.this.finish();
            }
        });
    }
}
