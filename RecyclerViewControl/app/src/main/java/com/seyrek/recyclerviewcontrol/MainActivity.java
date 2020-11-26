package com.seyrek.recyclerviewcontrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LayoutInflater layoutInflater;
    ArrayList<ListItem> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        list.add(new ListItem("Shack",R.drawable.klube));
        list.add(new ListItem("Yellow Flower",R.drawable.cicek));
        list.add(new ListItem("Light",R.drawable.isik));
        list.add(new ListItem("Shack",R.drawable.klube));
        list.add(new ListItem("Yellow Flower",R.drawable.cicek));
        list.add(new ListItem("Light",R.drawable.isik));
        list.add(new ListItem("Shack",R.drawable.klube));
        list.add(new ListItem("Yellow Flower",R.drawable.cicek));
        list.add(new ListItem("Light",R.drawable.isik));
        list.add(new ListItem("Shack",R.drawable.klube));
        list.add(new ListItem("Yellow Flower",R.drawable.cicek));
        list.add(new ListItem("Light",R.drawable.isik));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);

    }

    class Adapter extends RecyclerView.Adapter<ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(layoutInflater.inflate(R.layout.control_cell_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.imageView.setImageResource(list.get(position).getResourceId());
            holder.textTitle.setText(list.get(position).getName());
            holder.position = position;

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textTitle;
        int position;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textTitle = itemView.findViewById(R.id.textTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,list.get(position).getName()+" clicked!",Toast.LENGTH_SHORT).show();

        }
    }

    class ListItem{
        String name;
        int resourceId;

        public ListItem(String name, int resourceId) {
            this.name = name;
            this.resourceId = resourceId;
        }

        public String getName() {
            return name;
        }

        public int getResourceId() {
            return resourceId;
        }
    }
}
