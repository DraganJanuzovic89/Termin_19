package com.ftninformatika.termin_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.OnElementClickListener {


    RecyclerView rvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();



    }

    private List<String> getData(){
        List<String> data = new ArrayList<>();
        for (int i = 0; i<20; i++){
            data.add("Element " + i);
        }
        return data;

    }
    private void setupRecyclerView(){
        rvList = findViewById((R.id.rvList));
        rvList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        MyRecyclerAdapter adapter  = new MyRecyclerAdapter(this, getData());
        rvList.setAdapter(adapter);

    }

    @Override
    public void OnElementClicked(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}