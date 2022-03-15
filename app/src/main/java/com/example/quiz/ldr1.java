package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ldr1 extends Fragment {
    private RecyclerView myrecyclerview;
    private List<item_init> item;
    View v;
    private SharedPreferences sp;
    private SharedPreferences sj;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_ldr1, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler);
        RecyclerViewAdapter myrecylceviewadapter = new RecyclerViewAdapter(getContext(), item);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(myrecylceviewadapter);

        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sc = sp.getInt("score", 0);
        String ab = sj.getString("name", "");
        String j=String.valueOf(sc);
        editor=sp.edit();
        editor=sj.edit();
        item=new ArrayList<>();
        item.add(new item_init(ab,j));
    }
}
