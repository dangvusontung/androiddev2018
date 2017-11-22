package xyz.sonbn.ircclient.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xyz.sonbn.ircclient.R;
import xyz.sonbn.ircclient.model.Server;

public class AddServerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_CHANNELS       = 1;
    private static final int REQUEST_CODE_AUTHENTICATION = 2;
    private Server server;
    private Button authenticationBtn, channelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_server);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.addView(LayoutInflater.from(this).inflate(R.layout.item_done_discard, toolbar, false));

        authenticationBtn = (Button) findViewById(R.id.authentication);
        channelBtn = (Button) findViewById(R.id.channels);

        authenticationBtn.setOnClickListener(this);
        channelBtn.setOnClickListener(this);

        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.authentication:
                Intent authIntent = new Intent(this, AuthenticationActivity.class);
                startActivityForResult(authIntent, REQUEST_CODE_AUTHENTICATION);
                break;
            case R.id.channels:
                Intent channelIntent = new Intent(this, AddChannelActivity.class);
                startActivityForResult(channelIntent, REQUEST_CODE_CHANNELS);
                break;
        }
    }

    public void onCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onSave(View view) {
        try {
            if (server == null) {
                addServer();
            } else {
                updateServer();
            }
            setResult(RESULT_OK);
            finish();
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void addServer(){

    }

    private void updateServer(){

    }
}
