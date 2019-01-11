package com.fffrowies.searchlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = new String[]{"Andrew", "Maria", "George", "Lisa", "Lino", "Gina", "Robert",
                "Jerome", "Marian", "Fernando", "Angela", "Jack", "Sarah", "Lucas", "Jonathan",
                "Grabrielle", "Paul", "Camille", "John", "Rita", "Chris"};
        description = new String[]{"Hasaj 1153443578", "Maria 1123459876", "Coleman 1172635427",
                "Mona 1142466246", "Solanas 1174355698", "Hidalgo 1197763523", "Schuman 1146334455",
                "Kern 1132445769", "Marais 1172549065", "Bowies 1158498373", "Castro 1158495216",
                "Riber 1145453322", "Rowiers 1134323454", "Almeria 1147385562", "Soto 1122332233",
                "Pinedo 1125696361", "McDowell 1135673467", "Light 1135447377", "Lenox 1198763212",
                "Coolidge 1155325435", "Cornell 1142569809"};
        icon = new int[]{R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04,
                R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08,
                R.drawable.pic09, R.drawable.pic10, R.drawable.pic11, R.drawable.pic12,
                R.drawable.pic13, R.drawable.pic14, R.drawable.pic15, R.drawable.pic16,
                R.drawable.pic17, R.drawable.pic18, R.drawable.pic19, R.drawable.pic20,
                R.drawable.pic21};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            // bind all strings in an array
            arrayList.add(model);
        }

        // pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        // bind the adapter to the listView
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(newText);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
