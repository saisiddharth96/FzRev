package siddharth.com.fzrev.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import siddharth.com.fzrev.Adapters.RecyclerViewAdapter;
import siddharth.com.fzrev.Data.Data;
import siddharth.com.fzrev.DataLoading.LoadData;
import siddharth.com.fzrev.R;

/**
 * Created by saisi on 07-Jul-17.
 */

public class AllPostsRecyclerViewFragment extends Fragment {
    private RecyclerView.Adapter adapter;
    List<Data> datas;
    private RecyclerView recyclerViewPosts;
    Context context;


    public AllPostsRecyclerViewFragment() {
        }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.posts_main_recycler_view,container,false);


         recyclerViewPosts = v.findViewById(R.id.recyclerViewMain);

        new LoadData().execute("http://www.fzrev.com/wp-json/wp/v2/posts?fields=id,title,content,better_featured_image,link");
        adapter = new RecyclerViewAdapter(datas,context);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewPosts.setAdapter(adapter);
        return  v;

    }


}
