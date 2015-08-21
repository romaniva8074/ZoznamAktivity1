package com.example.roman.zoznamaktivity1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> verze = Arrays.asList("1.5 Cupcake", "1.6 Donut", "2.0 Eclair", "2.2 Froyo",
                "2.3 Gingerbread", "3.0 Honyecomb", "4.0 Ice Cream Sandwich", "4.1 Jelly Bean",
                "4.4 KitKat");
        ArrayAdapter<String> listAdaper =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        verze);
        setListAdapter(listAdaper);

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "Kontext polozky: " +
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
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
