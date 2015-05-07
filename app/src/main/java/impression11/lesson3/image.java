package impression11.lesson3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;


public class image extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    public void getImg(View view){

        final EditText name = (EditText) findViewById(R.id.Name);
        final ImageView displayImage = (ImageView) findViewById(R.id.exampleimage);
        // Link for image url - you could have got the image url from JSON, XML or RSS
        String url = "http://impresserve.co.uk/android/android.jpg";
        RequestQueue queue = Volley.newRequestQueue(this);

        ImageRequest imgReq = new ImageRequest(url, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap response) {
                //display image in the image view in the XML
                displayImage.setImageBitmap(response);

            }
        }, 0, 0, null, null);
        // Max Width, Max Height, docder config, error listener

        queue.add(imgReq);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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
