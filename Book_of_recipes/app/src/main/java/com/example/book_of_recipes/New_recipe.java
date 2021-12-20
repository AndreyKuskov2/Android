package com.example.book_of_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class New_recipe extends AppCompatActivity {

    private static final int CAMERA_PIC_REQUEST = 1;

    EditText name, descr;
    EditText ingredient;
    ImageView photo;
    Button addPhoto;
    Button btnAdd, btnExit;
    Bitmap bitmap;

    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        ingredient = (EditText)findViewById(R.id.editTextTextPersonName3);

        btnExit = findViewById(R.id.button);
        name = (EditText)findViewById(R.id.editTextTextPersonName);
        btnAdd = (Button)findViewById(R.id.button2);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
        descr = findViewById(R.id.editTextTextPersonName2);
        addPhoto = (Button) findViewById(R.id.button3);
        photo = (ImageView) findViewById(R.id.imageView);
        addPhoto.setOnClickListener(this::startCamera);
        btnAdd.setOnClickListener(this::addNewIng);
        btnExit.setOnClickListener(this::new_act);
    }

    public void new_act(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", name.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void addNewIng(View v)
    {
        mNameList.add(ingredient.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    public void startCamera(View v)
    {
        // TODO Auto-generated method stub
        Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == CAMERA_PIC_REQUEST)
        {
            bitmap=(Bitmap)data.getExtras().get("data");
            photo.setImageBitmap(bitmap);
        }
    }
}
