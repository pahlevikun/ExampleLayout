package com.example.examplelayout.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.example.examplelayout.R;
import com.example.examplelayout.database.DatabaseHandler;

public class HomeFragment extends Fragment {

    private GridView gridView;
    private ListAdapter adapter;
    DatabaseHandler database;
    SQLiteDatabase db;
    Cursor cursor;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        gridView = (GridView) view.findViewById(R.id.gridViewMenu);
        database = new DatabaseHandler(getActivity());
        db = database.getReadableDatabase();
        try{
            cursor = db.rawQuery("SELECT * FROM menu ORDER BY _id ASC", null);
            adapter = new SimpleCursorAdapter(getActivity(), R.layout.adapter_gridview, cursor, new String[] {"gambar", "nama"}, new int[] {R.id.imageView1, R.id.textView1});
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    //detail(position);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }


        return view;
    }


}
