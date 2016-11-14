package com.example.zizi.hitungluas;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Process;
import android.widget.Toast;

import java.lang.Thread.UncaughtExceptionHandler;

public class MainActivity extends Activity  {

    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;
    AlertDialogManager alert = new AlertDialogManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

//                double p = Double.parseDouble(panjang);
//                double l = Double.parseDouble(lebar);
//
//                double luas = p * l;
//
//                txtLuas.setText("Luas : "+luas);

                if (panjang.equals("") || lebar.equals(""))
                {
                    alert.showAlertDialog(MainActivity.this, "FAILED!", "Please fill the number", false);
                    return;
                }

                else
                {
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);

                    double luas = p * l;

                    txtLuas.setText("Luas : "+luas);
                }
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
