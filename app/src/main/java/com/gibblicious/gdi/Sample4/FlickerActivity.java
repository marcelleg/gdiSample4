package com.gibblicious.gdi.Sample4;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.gibblicious.gdi.Sample4.networking.FlickerApi;
import com.gibblicious.gdi.Sample4.networking.PhotoResponse;

import java.util.HashMap;
import java.util.Map;

public class FlickerActivity extends AppCompatActivity {

    private static String TAG = "FlickerActivity";

    FlickerApi flicker;
    FlickerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicker);

        setupViews();

        initNetworking();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //populate RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.image_list);

        LinearLayoutManager layoutMgr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutMgr);

        adapter = new FlickerAdapter(this);
        recyclerView.setAdapter(adapter);

        EditText keyword = (EditText) findViewById(R.id.text_keyword);
        keyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                fetchEvents(textView.getText().toString());
                return true;
            }
        });
    }


    private void initNetworking() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flicker = retrofit.create(FlickerApi.class);

    }

    private void fetchEvents(String keyword) {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        Map<String, String> queryMap = buildQuery(keyword);

        flicker.getPhotos(queryMap).enqueue(new Callback<PhotoResponse>() {

            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                PhotoResponse pr = response.body();
                hideKeyboard();
                progressBar.setVisibility(View.GONE);
                adapter.setImageList(pr.getPhotos());
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                showToastError(t.getMessage());
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    private void showToastError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private Map<String, String> buildQuery(String keyword) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("text", keyword);
        queryMap.put("api_key", "de7f29e36c9c6d771425cf83765179f4");
        queryMap.put("format", "json");
        queryMap.put("method", "flickr.photos.search");
        queryMap.put("nojsoncallback", "1");
        return queryMap;

    }
}
