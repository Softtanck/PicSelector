package com.softtanck.picselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.softtanck.picselector.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private GridLayoutManager gridLayoutManager;

    private MyAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rl);

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("--+" + i);
        }
        adapter = new MyAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
    }
}
