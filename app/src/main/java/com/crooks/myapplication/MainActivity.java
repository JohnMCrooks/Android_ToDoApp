package com.crooks.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView listView;
    EditText text;
    Button addButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.addButton);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(items);

        addButton.setOnClickListener(this);    //create the class as a listener, then implement the interface (View.OnClickListener in this case), and
        listView.setOnItemLongClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        Toast.makeText(this, "Item Deleted!", Toast.LENGTH_LONG).show();
        return true;
    }
}
