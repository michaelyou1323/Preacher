package com.michaelyou2000.myapp3.New;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.michaelyou2000.myapp3.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;

    ArrayList<User> users;


    public MyAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View v = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
          return  new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position1 ) {



        User user = users.get(holder.getPosition());


        holder.name.setText(user.getName());

//        RequestOptions options = new RequestOptions()
//                .fitCenter()
//                .placeholder(R.drawable._682029664641)
//                .error(R.drawable.photoroom_20230516_142426);

        Glide.with(context )
                .load(users.get(holder.getPosition()).getImage())
                .into(holder.image);


//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                User dataModel = users.get(holder.getPosition());
//
//                String url = user.getLink();
//                if(url != null){
//
//                    if (url.startsWith("https://") || url.startsWith("http://")){
//                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                    }
//                }
//
//
//
//            }
//        });

        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = user.getLink();
                if (url != null){

                    if (url.startsWith("https://") || url.startsWith("http://")){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    }
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return users.size();

    }


    public void setUsersList(ArrayList<User> users) {
        this.users = users;


    }



    public  static  class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.tvTitle);
        }
    }
}
