package com.promise.gadsbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SpecificBookAdapter extends RecyclerView.Adapter<SpecificBookAdapter.SpecificHolder> {
    private List<Book> books;

    public SpecificBookAdapter(List<Book> books) {
        this.books = books;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificHolder holder, int position) {
        Book model = books.get(position);
        holder.topic.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        Picasso.get().load(model.getImage()).placeholder(R.drawable.appstore).error(R.drawable.appstore).fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @NonNull
    @Override
    public SpecificHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SpecificHolder(view);
    }

    public static class SpecificHolder extends RecyclerView.ViewHolder {
        TextView topic, description;
        ImageView imageView;
        public SpecificHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topic);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
