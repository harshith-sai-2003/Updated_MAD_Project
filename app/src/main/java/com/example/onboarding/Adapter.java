package com.example.onboarding;

import static java.net.Proxy.Type.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboarding.data.MyDbHandler;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<ModelClass> userList;
    List<StartupClass>list;
    MyDbHandler db;
    public Adapter(List<ModelClass> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        db = new MyDbHandler(parent.getContext());
        list=db.getAllStartups();
        //int temp=view.getId();
        //Toast.makeText(parent.getContext(),String.valueOf(temp),Toast.LENGTH_SHORT).show();
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
        private TextView textView1,textView2,textView3,divider,popup2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageView=itemView.findViewById(R.id.image1);
            textView1=itemView.findViewById(R.id.tv1);
            textView2=itemView.findViewById(R.id.tv2);
            textView3=itemView.findViewById(R.id.tv3);
            divider=itemView.findViewById(R.id.tv4);


            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popup = new PopupMenu(view.getContext(), view);
                    Menu m = popup.getMenu();
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.menu, popup.getMenu());
                    popup2=view.findViewById(R.id.mail_popup);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                            intent.putExtra(Intent.EXTRA_EMAIL, textView3.getText().toString().trim());
                            //Log.d("email", "onMenuItemClick: "+textView3.getText().toString().trim());
                            intent.putExtra(Intent.EXTRA_SUBJECT, "String");
                                view.getContext().startActivity(intent);


                            return false;
                        }
                    });
                    //popup2.setText();
                    popup.show();
                    //Toast.makeText(view.getContext(),"onClick: clicked ",Toast.LENGTH_SHORT).show();
                }
            });

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


           // Toast.makeText(v.getContext(),"onClick: clicked " + list.get(position).getCompany_name(),Toast.LENGTH_SHORT).show();
            Log.d("ClickListener", "onClick: clicked " + position);
        }
    }
}
