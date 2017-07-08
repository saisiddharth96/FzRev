package siddharth.com.fzrev.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import siddharth.com.fzrev.Data.Data;
import siddharth.com.fzrev.R;
import siddharth.com.fzrev.ActivityClasses.WebViewOfPosts;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Data data =  new Data();
    private List<Data> datas;
    private Context context;


    public RecyclerViewAdapter(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public RecyclerViewAdapter(List<Data> datas, FutureCallback<JsonArray> futureCallback) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.recyclerviewcards,parent,false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        datas.get(position);
        holder.Title.setText(Html.fromHtml(data.getTitle()));
        holder.Excerpt.setText(Html.fromHtml(data.getContent()));
        Glide.with(context).load((data.getFeaturedImage())).into(holder.FeaturedImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), WebViewOfPosts.class);
                i.putExtra("link", data.getLink());
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        datas = new ArrayList<>();
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Title;
        public TextView Excerpt;
        public ImageView FeaturedImage;
        public ViewHolder(View itemView) {
            super(itemView);
            Title = (TextView)itemView.findViewById(R.id.HeadingTextView);
            Excerpt = (TextView)itemView.findViewById(R.id.TextExcerpt);
            FeaturedImage = (ImageView)itemView.findViewById(R.id.FeaturedImage);
        }
    }

}
