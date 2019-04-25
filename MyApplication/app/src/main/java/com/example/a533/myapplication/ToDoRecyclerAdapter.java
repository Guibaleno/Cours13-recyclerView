package com.example.a533.myapplication;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
public class ToDoRecyclerAdapter extends RecyclerView.Adapter<ToDoRecyclerAdapter.MyViewHolder> {
List<Todo> todoList;
public static  class MyViewHolder extends RecyclerView.ViewHolder{
TextView title;
TextView description;
TextView date;
    public MyViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.textViewTitle);
        description = itemView.findViewById(R.id.textViewDescription);
        date = itemView.findViewById(R.id.textViewDate);
    }
}
public ToDoRecyclerAdapter(List<Todo> todoList)
{
    this.todoList = todoList;
}
    @NonNull
    @Override
    public ToDoRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
    MyViewHolder vh = new MyViewHolder(v);
    return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull ToDoRecyclerAdapter.MyViewHolder holder, int position) {
        Todo todoToDisplay = todoList.get(position);
        holder.title.setText(todoToDisplay.getTitle());
        holder.date.setText(todoToDisplay.getDateAdded().toString());
        holder.description.setText(todoToDisplay.getDescription());
    }
    @Override
    public int getItemCount() {
        return todoList.size();
    }
}