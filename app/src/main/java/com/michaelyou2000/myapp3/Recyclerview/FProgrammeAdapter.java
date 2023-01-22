package com.michaelyou2000.myapp3.Recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.michaelyou2000.myapp3.R;

public class FProgrammeAdapter extends FirebaseRecyclerAdapter<FirstProgrammeDataModel,FProgrammeAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public FProgrammeAdapter(@NonNull FirebaseRecyclerOptions<FirstProgrammeDataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull FirstProgrammeDataModel model) {

        holder.name.setText(model.getName());


//        Glide.with(holder.img.getContext())
//                        .load(R.drawable.mr_baby_4077)
//                                .into(holder.img);


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = model.getLink();
//                if (url.startsWith("https://") || url.startsWith("http://")){
//                    v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                }
//
//            }
//        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);

        return new myViewHolder(view);
    }



    static class myViewHolder extends RecyclerView.ViewHolder{

//        ImageView img;
        TextView  name;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
//            img = (ImageView) itemView.findViewById(R.id.ivFProgramme);
            name = (TextView) itemView.findViewById(R.id.tvEpisTitle);


        }
    }
}
