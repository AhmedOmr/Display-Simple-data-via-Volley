package com.mecodroid.volley_example;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Models> lis;
    ArrayList<Models> volleylists;
    VolleyadapterList adapterList;
    RecyclerView rv;
    ProgressBar bar;
    CheckInternet checkInternet;
    boolean a;
    JsonArrayRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.vrec);
        checkInternet = new CheckInternet(MainActivity.this);
        lis = new ArrayList();
        LinearLayoutManager lin = new LinearLayoutManager(this);
        rv.setLayoutManager(lin);
        a = checkInternet.Is_Connecting();
        if (!a) {
            Toast.makeText(MainActivity.this, "please check Internet Connection", Toast.LENGTH_LONG).show();
       finish();
        } else {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL ur = new URL("https://jsonplaceholder.typicode.com/users");
                         request = new JsonArrayRequest(Request.Method.GET
                                , ur.toString(), null, new Response.Listener<JSONArray>() {
                            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                            @Override
                            public void onResponse(JSONArray response) {
                                try {

                                    JSONArray jsonArrayparent = (JSONArray) response;

                                    JSONObject jsonparent = response.getJSONObject(0);
                                    for (int i = 0; i < jsonArrayparent.length(); i++) {
                                        JSONObject jsonObject = jsonArrayparent.getJSONObject(i);
                                        String name = jsonObject.getString("name");

                                        String email = jsonObject.getString("email");
                                        String phone = jsonObject.getString("phone");
                                        JSONObject address = jsonObject.getJSONObject("address");
                                        String street = address.getString("street");
                                        String city = address.getString("city");
                                        JSONObject company = jsonObject.getJSONObject("company");
                                        String name1 = company.getString("name");

                                        lis.add(new Models(name, email, phone, street + "," + city, name1));
                                    }
                                    volleylists = new ArrayList<>();
                                    volleylists.addAll(lis);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                adapterList = new VolleyadapterList(getApplicationContext(), volleylists);
                                rv.setAdapter(adapterList);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        );

                        Volley.newRequestQueue(getApplicationContext()).add(request);


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
