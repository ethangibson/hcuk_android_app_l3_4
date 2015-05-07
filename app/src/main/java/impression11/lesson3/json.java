package impression11.lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class json extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    public void sendName(View view){

        final EditText name = (EditText) findViewById(R.id.Name);
        final TextView text = (TextView) findViewById(R.id.result);

        String url = "http://impresserve.co.uk/android/json.php?name=" + name.getText();
        RequestQueue queue = Volley.newRequestQueue(this);
        // JSON Object Request - bare in mind you may not be able to parse a JSON Array, make sure your source is a proper formatted object!
        JsonObjectRequest req = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Use try and catch - JSON may be sent back even if you don't get the response you want
                        // so we use this to catch any errors which might crash the app
                        try {
                            text.setText(response.getString("name"));
                        } catch (JSONException e) {
                            // If the JSON doesn't come back as expected - basically if "try" comes back with an error
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // On Volley error (usually no resposnse or not the correct JSON format)
                Log.w("json", error);
            }
        });

        queue.add(req);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_json, menu);
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
