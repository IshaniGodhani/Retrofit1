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
        View view= LayoutInflater.from(context).inflate(R.layout.item_file2,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_post.View_Holder holder, int position) {
        holder.textView.setText(postdatalist.get(position).getUserId().toString());
        holder.txt1.setText(postdatalist.get(position).getId().toString());
        holder.txt2.setText(postdatalist.get(position).getTitle().toString());
        holder.txt3.setText(postdatalist.get(position).getBody().toString());
    }

    @Override
    public int getItemCount() {
        return postdatalist.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView textView,txt1,txt2,txt3;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt);
            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
            txt3=itemView.findViewById(R.id.txt3);
        }
    }
}
