package com.example.retrofit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter_user extends RecyclerView.Adapter<RecyclerAdapter_user.View_Holder> {
    Activity activity;
    List<DataModel> dataModelList=new ArrayList<>();
    public RecyclerAdapter_user(Activity activity, List<DataModel> dataModelList) {
        this.activity=activity;
        this.dataModelList=dataModelList;
    }

    @NonNull
    @Override
    public RecyclerAdapter_user.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.item_file,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_user.View_Holder holder, int position) {
        holder.txt.setText(dataModelList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView txt,txt1,txt2,txt3,txt4;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
        }
    }
}
