package unicauca.movil.blecentral;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import unicauca.movil.blecentral.adapters.DeviceAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static final ParcelUuid SERVICE_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
    static final ParcelUuid DATA_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
    
    Switch state;
    TextView txtState;
    ListView list;
    DeviceAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtState = (TextView) findViewById(R.id.txt_state);

        state = (Switch) findViewById(R.id.state);
        state.setOnClickListener(this);

        list = (ListView) findViewById(R.id.list);
        listAdapter = new DeviceAdapter(this);
        list.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View view) {
        if(state.isChecked()){
            txtState.setText(R.string.state_scan);
            startScan();
        }else{
            txtState.setText(R.string.state_no_scan);
            stopScan();
        }
    }

    private void startScan() {

    }

    private void stopScan() {

    }


}
