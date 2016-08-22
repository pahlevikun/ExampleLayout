package com.example.examplelayout.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.examplelayout.R;
import com.example.examplelayout.database.DatabaseHandler;


public class HelpFragment extends Fragment{

    protected ListAdapter adapter;
    protected ListView listView;
    DatabaseHandler database;
    SQLiteDatabase db;
    Cursor cursor;


    public HelpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        listView = (ListView) view.findViewById(R.id.listHelp);
        database = new DatabaseHandler(getActivity());
        db = database.getReadableDatabase();

        try{
            cursor = db.rawQuery("SELECT * FROM menu ORDER BY _id ASC LIMIT 5", null);
            adapter = new SimpleCursorAdapter(getActivity(), R.layout.adapter_listview, cursor, new String[] {"gambar", "nama"}, new int[] {R.id.ivGambar, R.id.tvPenjelasan});
            listView.setAdapter(adapter);
            listView.setTextFilterEnabled(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
