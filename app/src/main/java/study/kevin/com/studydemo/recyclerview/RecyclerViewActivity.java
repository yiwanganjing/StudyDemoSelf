package study.kevin.com.studydemo.recyclerview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import study.kevin.com.studydemo.R;

/**
 * Created by kevin on 2018/4/14.
 */

public class RecyclerViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<String> mDatalist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


/***
 * listview
 */
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));


/**
 * gridView
 */
        StaggeredGridLayoutManager sManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager(sManager);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this,4));


        mDatalist = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            mDatalist.add("item" + i);
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mDatalist);
        recyclerView.setAdapter(adapter);

    }
}
