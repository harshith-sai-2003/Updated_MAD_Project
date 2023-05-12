package com.example.onboarding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<ModelClass> userList;

    public Adapter(List<ModelClass> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int res=userList.get(position).getCardview();
        String name=userList.get(position).getTv1();
        String message=userList.get(position).getTv3();
        String time=userList.get(position).getTv2();
        String line=userList.get(position).getDivider();
        holder.setData(res,name,message,time,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView1,textView2,textView3,divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageView=itemView.findViewById(R.id.image1);
            textView1=itemView.findViewById(R.id.tv1);
            textView2=itemView.findViewById(R.id.tv2);
            textView3=itemView.findViewById(R.id.tv3);
            divider=itemView.findViewById(R.id.tv4);

        }

        public void setData(int res, String name, String message, String time, String line) {
            imageView.setImageResource(res);
            textView1.setText(name);
            textView3.setText(message);
            textView2.setText(time);
            divider.setText(line);
        }

        @Override
        public void onClick(View v) {

            int position=this.getAdapterPosition();
            Log.d("ClickListener", "onClick: clicked " + position);
        }
    }
}
