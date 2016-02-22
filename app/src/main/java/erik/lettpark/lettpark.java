package erik.lettpark;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class lettpark extends AppCompatActivity {

    private BluetoothAdapter BA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lettpark);


        BA = BluetoothAdapter.getDefaultAdapter();
        if (!BA.isEnabled())
        {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            if(BA.isEnabled())
            {
                Toast.makeText(getApplicationContext(), "Bluetooth is on", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Please turn on Bluetooth", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Bluetooth is on", Toast.LENGTH_LONG).show();
        }
        Button next = (Button) (findViewById(R.id.start_system));
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(BA.isEnabled())
                {
                    Intent neste = new Intent(v.getContext(), erik.lettpark.Sensor.class);
                    startActivityForResult(neste, 0);
                }
                else
                {
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                    Toast.makeText(getApplicationContext(), "Please turn on Bluetooth", Toast.LENGTH_LONG).show();
                }
            }


        });

        }

}
