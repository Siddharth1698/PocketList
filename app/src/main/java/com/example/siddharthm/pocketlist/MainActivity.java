package com.example.siddharthm.pocketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    Button add;
    Button clear;
    Button clearList;
    ListView list;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.editText);
        add = (Button)findViewById(R.id.button2);
        clearList = (Button)findViewById(R.id.button3);
        clear = (Button)findViewById(R.id.button);
        list = (ListView)findViewById(R.id.list);

        final ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.add(t1.getText().toString());
                list.setAdapter(itemsAdapter);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
            }
        });
        clearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        itemsAdapter.clear();
               list.setAdapter(itemsAdapter);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemsAdapter.remove(itemsAdapter.getItem(position));
               itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });



    }

}
