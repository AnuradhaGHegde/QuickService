package com.android.quickservice.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.quickservice.app.orderhistorymodel.OrderHistoryModel;
import com.android.quickservice.app.orderhistorymodel.PAYMENT_STATE;
import com.android.quickservice.app.workermodel.BaseWorkerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderDetailActivity extends AppCompatActivity  implements ValueEventListener{

    OrderHistoryModel orderData;
    private DatabaseReference mDatabaseRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);


        Intent intent = getIntent();
        orderData =(OrderHistoryModel) intent.getSerializableExtra("Order_Data");
        setTitle(orderData.getmOrderID());
        SetWorkerData();

        this.mDatabaseRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference childref = mDatabaseRootRef.child("QuickServiceDB/Services");
        childref.addValueEventListener(this);

    }

    private void SetWorkerData() {

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
        TextView billIDTxtVw = (TextView) findViewById(R.id.billIDTxtWv);
        Button makepaymentBtn = (Button) findViewById(R.id.makepaymentBtn);
        TextView paymentStateTxtVw = (TextView) findViewById(R.id.paymentStateTxtVw);

        workernameTxtVw.setText(orderData.getmWorkerModel().getmWorkerName());
        workerIDTxtVw.setText(orderData.getmWorkerModel().getmWorkerID());
        workerAddressTxtVw.setText(orderData.getmWorkerModel().getmAddress());
        workerServicesTxtVw.setText(orderData.getmWorkerModel().getmServiceDesc());
        workerRatingTxtVw.setText(Double.toString(orderData.getmWorkerModel().getmRating())+"/5");
        workerlabourRateTxtVw.setText(orderData.getmWorkerModel().getmLabourRate());
        workertaxTxtVw.setText(orderData.getmWorkerModel().getmTaxes());
        workerDiscountTxtVw.setText(orderData.getmWorkerModel().getmDiscount());
        workerCOSTTxtVw.setText(CalculateTotalCost());
        billIDTxtVw.setText(orderData.getmOrderID());
        paymentStateTxtVw.setText(orderData.getPaymentState().toString());
      //  workerAvailabilityTxtVw.setText(orderdata.getmWorkerModel().getmAvailability());

        if(orderData.getPaymentState() == PAYMENT_STATE.PENDING)
        {
            paymentStateTxtVw.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.text_color_black_color_red));

            makepaymentBtn.setVisibility(View.VISIBLE);
        }
        else if (orderData.getPaymentState() == PAYMENT_STATE.COMPLETED)
        {
            paymentStateTxtVw.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.text_color_black_color_green));
            makepaymentBtn.setVisibility(View.GONE);
        }
        else if (orderData.getPaymentState() == PAYMENT_STATE.CANCELLED)
        {
            //paymentStateTxtVw.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.gr));
            makepaymentBtn.setVisibility(View.GONE);
        }

    }

    public void OnMakePaymentClick(View v)
    {
        orderData.setPaymentState(PAYMENT_STATE.COMPLETED);
        String childPath = "QuickServiceDB/OrderHistory/"+orderData.getmOrderObjectID()+ "/paymentState";
        mDatabaseRootRef.child(childPath).setValue(orderData.getPaymentState());

        TextView paymentStateTxtVw = (TextView) findViewById(R.id.paymentStateTxtVw);
        paymentStateTxtVw.setText(orderData.getPaymentState().toString());
        Button makePaymentBtn = (Button) findViewById(R.id.makepaymentBtn);
        makePaymentBtn.setVisibility(View.GONE);
    }
    private String CalculateTotalCost() {

        float laborCost =Float.parseFloat(orderData.getmWorkerModel().getmLabourRate());
        float taxes =(Float.parseFloat(orderData.getmWorkerModel().getmTaxes()))/100;
        float disc =(Float.parseFloat(orderData.getmWorkerModel().getmDiscount()))/100;

        float Totalcost = laborCost +(laborCost*taxes)-(laborCost*disc);
        return Float.toString(Totalcost) ;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
