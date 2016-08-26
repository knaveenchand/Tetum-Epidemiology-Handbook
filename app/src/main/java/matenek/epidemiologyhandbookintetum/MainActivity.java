package matenek.epidemiologyhandbookintetum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText filterText;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterText = (EditText) findViewById(R.id.editText);
        final ListView itemList = (ListView) findViewById(R.id.listView);

        DbBackend dbBackend = new DbBackend(MainActivity.this);
        String[] terms = dbBackend.dictionaryWords();

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, terms);

        itemList.setAdapter(listAdapter);


        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String lookupword = (String) itemList.getItemAtPosition(position);

// make Toast when click
/*
                Toast.makeText(getApplicationContext(), "Searching " + lookupword, Toast.LENGTH_LONG).show();
*/
                Intent intent = new Intent(MainActivity.this, DictionaryActivity.class);
                intent.putExtra("DICTIONARY_ID", lookupword);
                startActivity(intent);
            }
        });

        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }


}
