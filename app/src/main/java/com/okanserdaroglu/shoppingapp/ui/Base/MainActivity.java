package com.okanserdaroglu.shoppingapp.ui.Base;

import android.os.Bundle;

import com.okanserdaroglu.shoppingapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
    }
}
