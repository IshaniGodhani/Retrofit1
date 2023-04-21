package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Models.PostDataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter_post extends RecyclerView.Adapter<RecyclerAdapter_post.View_Holder> {
    Context context;
    List<PostDataModel> postdatalist=new ArrayList<>();
    public RecyclerAdapter_post(Context context, List<PostDataModel> postdatalist) {
        this.context=context;
        this.postdatalist=postdatalist;
    }

    @NonNull
    @Override
    public RecyclerAdapter_post.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_file,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_post.View_Holder holder, int position) {
        holder.textView.setText(postdatalist.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return postdatalist.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView textView;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt);
        }
    }
}
