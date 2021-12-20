package com.example.book_of_recipes;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ListView lst;
    ArrayAdapter mArrayAdapter;
    ImageView image;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView2);

        lst = (ListView) findViewById(R.id.list);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        lst.setAdapter(mArrayAdapter);
        registerForContextMenu(lst);

        fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        Intent intent;

        intent = new Intent(this, New_recipe.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null){
            return ;
        }
        String task_info = data.getStringExtra("name");

        mNameList.add(task_info);
    }
}
