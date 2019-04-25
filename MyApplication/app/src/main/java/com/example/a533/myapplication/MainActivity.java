package com.example.a533.myapplication;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
final Context context = this;
List<Todo> todoList = new ArrayList<>();
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewtoDo);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ToDoRecyclerAdapter(todoList);
        recyclerView.setAdapter(adapter);

        setListeners();
    }

    private void setListeners()
    {
        findViewById(R.id.btnDialogToDo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.create_dialog);
                Button dialogButtonAdd = dialog.findViewById(R.id.btnAdd);

                dialogButtonAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editTextTitle = dialog.findViewById(R.id.editTextTitle);
                        EditText editTextDescription = dialog.findViewById(R.id.editTextDescription);
                        Todo todo = new Todo(new Date(), editTextTitle.getText().toString(), editTextDescription.getText().toString());
                        todoList.add(todo);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}