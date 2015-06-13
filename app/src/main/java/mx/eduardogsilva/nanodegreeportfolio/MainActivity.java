package mx.eduardogsilva.nanodegreeportfolio;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Current toast to show per button
    private Toast currentToast;
    // Base position (of our coordinate system) from the top for reference in displaying the toast.
    private int baseTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set main layout
        setContentView(R.layout.activity_main);

        // Set uppercase programmatically. textAllCaps is only supported in API 14 and above.
        setUppercaseButton(R.id.btn_streamer);
        setUppercaseButton(R.id.btn_score);
        setUppercaseButton(R.id.btn_library);
        setUppercaseButton(R.id.btn_build_bigger);
        setUppercaseButton(R.id.btn_xyz);
        setUppercaseButton(R.id.btn_own);

        // Calculate base top
        baseTop = getBaseTop();

        // Get the margin bottom of the title
        float titleMarginBottom = getResources().getDimension(R.dimen.main_title_margin_bottom);

        // Margin bottom

        // Get final reference from top
        baseTop += getOriginalDimensionValue(titleMarginBottom);

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
        showToastForApp("streamer", view);
    }

    public void openScores(View view) {
        showToastForApp("scores", view);
    }

    public void openLibrary(View view) {
        showToastForApp("library", view);
    }

    public void openBuildBigger(View view) {
        showToastForApp("build it bigger", view);
    }

    public void openXYZ(View view) {
        showToastForApp("xyz reader", view);
    }

    public void openCapstone(View view) {
        showToastForApp("capstone", view);
    }

    // Utilities

    /**
     * Show toast over the button given by eventView.
     * @param appName   Name of the app to show in toast.
     * @param eventView View that triggered the event.
     */
    private void showToastForApp(String appName, View eventView) {
        // Get top position of the button.
        int top = baseTop + eventView.getTop();

        // Cancel current toast id existent.
        if(currentToast != null){
            currentToast.cancel();
        }

        currentToast = Toast.makeText(this, "This button will launch my " + appName + " app!", Toast.LENGTH_SHORT);
        // Set our base reference in the middle of the screen at the top.
        currentToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, top);
        currentToast.show();
    }

    /**
     * Gets ActionBar Size as described in:
     * <a href="https://stackoverflow.com/questions/7165830/what-is-the-size-of-actionbar-in-pixels"
     * >What is the size of ActionBar in pixels?</a>
     * @return ActionBar size as the base for our coordniate system
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public int getBaseTop() {
        // TODO need to find the proper way to implement in api level 10.
        final TypedArray styledAttributes = this.getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize });
        baseTop = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return baseTop;
    }

    /**
     * Returns the value specified in the xml file as in dp units.
     * Source: <a href="https://stackoverflow.com/questions/11121028/load-dimension-value-from-res-values-dimension-xml-from-source-code">
     * Load dimension value from res/values/dimension.xml from source code</a>
     * @param dimension Dimension given by getResources.
     * @return an int value representing the original value described in the resource.
     */
    public int getOriginalDimensionValue(float dimension) {
        int odv = (int) (dimension / getResources().getDisplayMetrics().density);
        return odv;
    }
}
