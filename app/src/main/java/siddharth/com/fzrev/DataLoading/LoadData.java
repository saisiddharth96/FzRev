package siddharth.com.fzrev.DataLoading;

import android.os.AsyncTask;

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
import java.util.ArrayList;
import java.util.List;

import siddharth.com.fzrev.Data.Data;



public class LoadData extends AsyncTask<String,String,List<Data>> {

    Data data = new Data();
    List<Data> datas;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected List<Data> doInBackground(String... params) {
        HttpURLConnection connection = null;

        datas = new ArrayList<>();

        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);

            }
            String finalJSON = buffer.toString();
            JSONArray parentArray = new JSONArray(finalJSON);

            for (int i = 0; i < parentArray.length(); i++) {
                JSONObject finalJSONObject = parentArray.getJSONObject(i);
                JSONObject parentTitle = finalJSONObject.getJSONObject("title");
                final String titleRendered = parentTitle.getString("rendered");

                JSONObject parentContent = finalJSONObject.getJSONObject("content");
                final String contentRendered = parentContent.getString("rendered");

                JSONObject featuredImage = finalJSONObject.getJSONObject("better_featured_image");
                final String featuredImageURL = featuredImage.getString("source_url");

                final String postLink = finalJSONObject.getString("link");

                data.setLink(postLink);
                data.setContent(contentRendered);
                data.setFeaturedImage(featuredImageURL);
                data.setTitle(titleRendered);

                datas.add(data);
            }

            return datas;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(List<Data> s) {
        super.onPostExecute(s);

    }
}
