package com.android.quickservice.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.quickservice.app.servicemodel.SERVICE_TYPE;

public class ServiceTypesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_types_list);
    }

    void onElectricalServiceCardClick(View v)
    {
        LoadActivity(SERVICE_TYPE.Electrical);
    }

    public void onElectronicServiceCardClick(View v)
    {
        LoadActivity(SERVICE_TYPE.Electronic);
    }

    public void onPlumbingServiceCardClick(View v)
    {
        LoadActivity(SERVICE_TYPE.Plumbing);
    }

    public void onFurnitureServiceCardClick(View v)
    {
        LoadActivity(SERVICE_TYPE.Furniture);
    }

    private void LoadActivity(SERVICE_TYPE serviceType) {

        Intent intent = new Intent(this, WorkersListActivity.class);
        intent.putExtra("SERVICE_TYPE",serviceType);
        startActivity(intent);
    }
}
