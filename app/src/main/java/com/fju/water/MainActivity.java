package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView edmonth;
    private TextView ednext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter();
            }
        });
    }
    public void enter() {
        String monthString = edmonth.getText().toString();
        if (!TextUtils.isEmpty(edmonth.getText().toString())) {
            float degree = Float.parseFloat(edmonth.getText().toString());
            float money = 0;
            if (degree < 31) {
                money = 7.35f * degree;
            } else if (degree < 31) {
                money = 9.45f * degree - 21;
            } else if (degree < 51) {
                money = 11.55f * degree - 84;
            } else if (degree > 51) {
                money = 12.075f * degree - 110.25f;
            }
            Intent intent = new Intent(this, ResultActivity.class);
            startActivities(intent);
            /*new AlertDialog.Builder(this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用:"+money)
                    .setPositiveButton("OK",null)
                    .show();*/
        } else {
            String nextString = ednext.getText().toString();
            if (!TextUtils.isEmpty(ednext.getText().toString())) {
                float degree = Float.parseFloat(ednext.getText().toString());
                float money = 0;
                if (degree < 21) {
                    money = 7.35f * degree;
                } else if (degree < 61) {
                    money = 9.45f * degree - 42;
                } else if (degree < 101) {
                    money = 11.55f * degree - 168;
                } else if (degree > 101) {
                    money = 12.075f * degree - 220.5f;
                }
                /*new AlertDialog.Builder(this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", null)
                        .show();*/
            }
        }

    }

    private void startActivities(Intent intent) {
    }

    public void reset(View view){
        edmonth.setText("");
        ednext.setText("");
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
