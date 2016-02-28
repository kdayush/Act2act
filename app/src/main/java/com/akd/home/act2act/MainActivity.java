package com.akd.home.act2act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    Button but;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but=(Button)findViewById(R.id.Check);
        ed=(EditText)findViewById(R.id.editText);
        setButtonOnClickListeners();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void setButtonOnClickListeners(){

        final Context context=this;
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLeapYear;
                final int year=Integer.parseInt(ed.getText().toString());
                if(year % 400 == 0)
                {
                    isLeapYear = true;
                }
                else if (year % 100 == 0)
                {
                    isLeapYear = false;
                }
                else if(year % 4 == 0)
                {
                    isLeapYear = true;
                }
                else
                {
                    isLeapYear = false;
                }
                Intent intent=new Intent(context,act2.class);
                if(isLeapYear)
                {
                    String str=year + " is a leap year";
                    intent.putExtra("message",str);
                }
                else
                {
                    String str=year+ " is not a leap year";
                    intent.putExtra("message",str);
                }
                startActivity(intent);
            }
        });
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
