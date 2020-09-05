package np.com.shresthakiran.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTableOf;
    ListView lvTableView;
    SeekBar skBarTableSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTableOf = findViewById(R.id.tvTableOf);
        lvTableView = findViewById(R.id.lvTableView);


        skBarTableSelect = findViewById(R.id.skBarTableSelect);
        skBarTableSelect.setMax(20);
        skBarTableSelect.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                tableCount(i);
                displayTable(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void displayTable(int tableI){
        tvTableOf.setText("Table of: "+ tableI);
        tvTableOf.setTextSize((float) 30.00);
        ArrayList <String> mulTable = new ArrayList<>();
        for(int j=1; j<=10; j++){
            mulTable.add((tableI) + " ✕ " + j + " = " + (tableI)*j);
        }
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mulTable );
        lvTableView.setAdapter(adapter);
    }

}