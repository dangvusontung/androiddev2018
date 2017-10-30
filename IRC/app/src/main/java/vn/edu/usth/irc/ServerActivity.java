package vn.edu.usth.irc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ServerActivity extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.server_label, mobileArray);

        ListView listView = (ListView) findViewById(R.id.server_list);
        listView.setAdapter(adapter);
    }
}
