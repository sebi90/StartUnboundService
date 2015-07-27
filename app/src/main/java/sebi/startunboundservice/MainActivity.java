package sebi.startunboundservice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private int count;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void clickedOnStart(View v) {

        switch (v.getId())
        {
            case R.id.buttonStart10:
                count = 10;
                Log.d(this.getClass().getName(), "starting service (" +
                        android.os.Process.myPid() + "-" +
                        Thread.currentThread().getName() + ")" + "count: " + count);
                intent = new Intent("sebi.UNBOUND_SERVICE");
                intent.putExtra("count",count);
                break;

            case R.id.buttonStart100:
                count = 100;
                Log.d(this.getClass().getName(), "starting service (" +
                        android.os.Process.myPid() + "-" +
                        Thread.currentThread().getName() + ")" + "count: " + count);
                intent = new Intent("sebi.UNBOUND_SERVICE");
                intent.putExtra("count",count);
                break;

            case R.id.buttonStart1000:
                count = 1000;
                Log.d(this.getClass().getName(), "starting service (" +
                        android.os.Process.myPid() + "-" +
                        Thread.currentThread().getName() + ")" + "count: " + count);
                intent = new Intent("sebi.UNBOUND_SERVICE");
                intent.putExtra("count",count);
                break;

        }

        intent.setPackage("sebi.unboundservice");
        startService(intent);

    }


    public void clickedOnStop(View view)
    {
        Log.d(this.getClass().getName(), "stopping service (" +
                android.os.Process.myPid() + "-" +
                Thread.currentThread().getName() + ")" + "count: " + count);
        intent = new Intent("sebi.UNBOUND_SERVICE");
        intent.setPackage("sebi.unboundservice");
        stopService(intent);

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
