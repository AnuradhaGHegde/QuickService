package com.android.quickservice.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.transition.Visibility;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.android.quickservice.app.workermodel.BaseWorkerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WorkerDetailViewActivity extends AppCompatActivity implements ValueEventListener {
    BaseWorkerModel workerdata;

    private DatabaseReference mDatabaseRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_detail_view);

        Intent intent = getIntent();
        workerdata =(BaseWorkerModel) intent.getSerializableExtra("Worker_Data");
        SetWorkerData(workerdata);

        this.mDatabaseRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference childref = mDatabaseRootRef.child("QuickServiceDB/Services");
        childref.addValueEventListener(this);
    }

    private void SetWorkerData(BaseWorkerModel workerdata) {

        TextView workernameTxtVw = (TextView) findViewById(R.id.workerNameTxtVw);
        TextView workerIDTxtVw = (TextView) findViewById(R.id.workerIDTxtWv);
        TextView workerAddressTxtVw = (TextView) findViewById(R.id.workerAddressTxtVw);
        TextView workerServicesTxtVw = (TextView) findViewById(R.id.servicedescriptionTxtVw);
        TextView workerRatingTxtVw = (TextView) findViewById(R.id.workerRatingTxtVw);
        TextView workerlabourRateTxtVw = (TextView) findViewById(R.id.workerLabourRateTxtVw);
        TextView workertaxTxtVw = (TextView) findViewById(R.id.taxesTxtVw);
        TextView workerDiscountTxtVw = (TextView) findViewById(R.id.workerDiscountTxtVw);
        TextView workerCOSTTxtVw = (TextView) findViewById(R.id.workerTotalCostTxtVw);
        TextView workerAvailabilityTxtVw = (TextView) findViewById(R.id.workerAvailabilityTxtVw);
        Button bookBtn = (Button) findViewById(R.id.booknowBtn);

        workernameTxtVw.setText(workerdata.getmWorkerName());
        workerIDTxtVw.setText(workerdata.getmWorkerID());
        workerAddressTxtVw.setText(workerdata.getmAddress());
        workerServicesTxtVw.setText(workerdata.getmServiceDesc());
        workerRatingTxtVw.setText(Double.toString(workerdata.getmRating())+"/5");
        workerlabourRateTxtVw.setText(workerdata.getmLabourRate());
        workertaxTxtVw.setText(workerdata.getmTaxes());
        workerDiscountTxtVw.setText(workerdata.getmDiscount());
        workerCOSTTxtVw.setText(CalculateTotalCost());
        workerAvailabilityTxtVw.setText(workerdata.getmAvailability());

        if(workerdata.getmAvailability().equals("Available"))
        {
            bookBtn.setVisibility(View.VISIBLE);
        }
        else if(workerdata.getmAvailability().equals("Booked"))
        {
            bookBtn.setVisibility(View.GONE);
        }

    }

    private String CalculateTotalCost() {
        //TODO: add total cost calc logic here
        return "0";
    }

    public void OnBookNowClick(View v)
    {
        Intent intent = getIntent();
        workerdata.setmAvailability("Booked");
        String childPath = "QuickServiceDB/Services/"+intent.getStringExtra("Service_ID")+
                "/mWorkerList/"+intent.getStringExtra("worker_data_pos")+
                "/mAvailability";
        mDatabaseRootRef.child(childPath).setValue(workerdata.getmAvailability());

        TextView workerAvailabilityTxtVw = (TextView) findViewById(R.id.workerAvailabilityTxtVw);
        workerAvailabilityTxtVw.setText(workerdata.getmAvailability());
        Button bookBtn = (Button) findViewById(R.id.booknowBtn);
        bookBtn.setVisibility(View.GONE);
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //TODO:Update Workerdetails realtime (reorganise code)
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
