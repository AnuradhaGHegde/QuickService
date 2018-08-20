package com.android.quickservice.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public void onViewServicesClick(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ServiceTypesListActivity.class);
        startActivity(intent);
    }

    public void onMyOrderHistoryClick(View v)
    {
        Intent intent = new Intent(getApplicationContext(), OrderHistoryActivity.class);
        startActivity(intent);
    }
}
