package com.michaelyou2000.myapp3.Recyclerview;

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
import com.michaelyou2000.myapp3.More.EventsActivity;
import com.michaelyou2000.myapp3.R;

import java.util.ArrayList;

public class EventsAdapter  extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {


        Context context;

        static ArrayList<EventsDataModel> eventsDataModels;




    public EventsAdapter(EventsActivity context, ArrayList<EventsDataModel> eventsDataModels) {
                       this.context = context;
                       this.eventsDataModels = eventsDataModels;
        
    }


    @NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return  new MyViewHolder(v);



        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        EventsDataModel eventsDataModel = eventsDataModels.get(position);
      //  holder.name.setText(eventsDataModel.getLink());

    holder.title.setText(eventsDataModels.get(position).getTitle());

    holder.description.setText(eventsDataModels.get(position).getDescription());

    Glide.with(context )
                    .load(eventsDataModels.get(position).getImageUrl())
                            .into(holder.imageView);


    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String url = eventsDataModel.getLink();
            if (url != null) {
                 if (url.startsWith("https://") || url.startsWith("http://")){
                     v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                 }
            }
        }
    });


//        holder.imageView.setOnClickListener(
//        new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        String url = eventsDataModel.getLink();
//        if (url.startsWith("https://") || url.startsWith("http://")){
//        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//        }
//       }
//        });
        }

@Override
public int getItemCount() {
        return eventsDataModels.size();

        }


public void setUsersList(ArrayList<EventsDataModel> users) {
        this.eventsDataModels = users;


        }



public  static  class MyViewHolder extends  RecyclerView.ViewHolder{


    TextView title;
    TextView description;
    ImageView imageView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image2);
        title = itemView.findViewById(R.id.tvTitle);
        description = itemView.findViewById(R.id.tvDescription);

    }
}

}