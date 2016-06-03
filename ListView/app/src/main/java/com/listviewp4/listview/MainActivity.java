package com.listviewp4.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private static String url = "http://jsonplaceholder.typicode.com/posts";
    private static final String userId = "playlist";
    private static final String id = "id";
    private static final String title = "title";
    private static final String body = "body";
    private MyJSON myJSON;
    private JSONObject jURL;
    private JSONArray jArray;

    private HashMap<String, String> hash;
    private ListAdapter adapter;
    private ArrayList<HashMap<String, String>> playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        myJSON = new MyJSON();
        jURL = myJSON.getJSONFromUrl(url);
        playlist = new ArrayList<HashMap<String, String>>();
        try {
            jArray = jURL.getJSONArray(userId);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject job = jArray.getJSONObject(i);
                String userId = job.getString("userId");
                String id = job.getString("id");
                String title = job.getString("title");
                String body = job.getString("body");

                hash = new HashMap<String, String>();
                hash.put(userId, userId);
                hash.put(id, id);
                hash.put(title, title);
                hash.put(body, body);

                playlist.add(hash);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            setList();
        }
    }

    private void setList() {
        adapter = new SimpleAdapter(this,R.layout.list_view,
                new String[] { userId, id, title, body }, new int[] {
                R.id.userId, R.id.id, R.id.title, R.id.body });
        setListAdapter(adapter);
    }

    private void setListAdapter(ListAdapter adapter) {
    }

}
