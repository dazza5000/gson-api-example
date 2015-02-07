package project.vichita.androidasynchttp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;


public class MainActivity extends ActionBarActivity {

    private TextView mTextView;
    private String URL = "http://blog.teamtreehouse.com/api/get_recent_summary/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        final Gson gson = new Gson();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
//                    mTextView.setText(new String(responseBody));
                    StringBuilder result = new StringBuilder();
                    Blog blog = gson.fromJson(new String(responseBody),Blog.class);
                    for (Post post:blog.getPosts()){
                        result.append("Title: "+post.getTitle()+"\n");
                        result.append("Author: "+post.getAuthor()+"\n");
                        result.append("Date: "+post.getDate()+"\n");
                        result.append("======================\n");
                    }

                    mTextView.setText(result);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        // POST
        /*RequestParams params = new RequestParams();
        params.put("name", "Marco Reus");
        params.put("national", "Germany");

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // check statusCode and get responsebody
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // throw err.
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
