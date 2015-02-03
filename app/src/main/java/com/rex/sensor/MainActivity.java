package com.rex.sensor;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.List;
import android.widget.ArrayAdapter;




public class MainActivity extends ActionBarActivity {

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SensorManager mySensorManager;
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Sensor> deviceSensors = mySensorManager.getSensorList(Sensor.TYPE_ALL);
        ListView listView = (ListView)findViewById(R.id.listView_sensor);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, deviceSensors);

        listView.setAdapter(adapter);

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
