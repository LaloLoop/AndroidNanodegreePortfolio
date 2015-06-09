package mx.eduardogsilva.nanodegreeportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set uppercase programmatically. textAllCaps is only supported in API 14 and above.
        setUppercaseButton(R.id.btn_streamer);
        setUppercaseButton(R.id.btn_score);
        setUppercaseButton(R.id.btn_library);
        setUppercaseButton(R.id.btn_build_bigger);
        setUppercaseButton(R.id.btn_xyz);
        setUppercaseButton(R.id.btn_own);
    }

    // Transform text in buttons to uppercase
    private void setUppercaseButton(int id) {
        Button button = (Button) findViewById(id);
        button.setText(button.getText().toString().toUpperCase());
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

    // App button handlers
    public void openStreamer(View view) {
        showToastForApp("streamer");
    }

    public void openScores(View view) {
        showToastForApp("scores");
    }

    public void openLibrary(View view) {
        showToastForApp("library");
    }

    public void openBuildBigger(View view) {
        showToastForApp("build it bigger");
    }

    public void openXYZ(View view) {
        showToastForApp("xyz reader");
    }

    public void openCapstone(View view) {
        showToastForApp("capstone");
    }

    // Utilities
    private void showToastForApp(String appName) {
        Toast.makeText(this, "This button will launch my " + appName + " app!", Toast.LENGTH_SHORT).show();
    }

}
