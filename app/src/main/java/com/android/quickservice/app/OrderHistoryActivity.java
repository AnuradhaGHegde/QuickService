package com.android.quickservice.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.quickservice.app.orderhistorymodel.OrderHistoryModel;
import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity implements ValueEventListener {

    ArrayList<OrderHistoryModel>  mOrderHistoryList;
    OrderHistoryCustomAdapter customAdapter;
    ListView listView;
    private DatabaseReference mDatabaseRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        ProgressBar progressIndicater = (ProgressBar)findViewById(R.id.listLoadprogressbar);
        progressIndicater.setVisibility(View.VISIBLE);

        listView = (ListView) findViewById(R.id.OrderHistoryListView);
       // FireBaseHelper help = new FireBaseHelper();
       // help.writeToFirebase();
        this.mDatabaseRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference childref = mDatabaseRootRef.child("QuickServiceDB/OrderHistory");
        childref.addValueEventListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OrderHistoryActivity.this, OrderDetailActivity.class);
                intent.putExtra("Order_Data",OrderHistoryActivity.this.mOrderHistoryList.get(i));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        ArrayList<OrderHistoryModel> orders = new ArrayList<>();
        for (DataSnapshot orderDataSnapshot : dataSnapshot.getChildren()) {
            OrderHistoryModel order = orderDataSnapshot.getValue(OrderHistoryModel.class);
            orders.add(order);
        }
            mOrderHistoryList=orders;
            customAdapter = new OrderHistoryCustomAdapter(getApplicationContext(), mOrderHistoryList);
            listView.setAdapter(customAdapter);
             ProgressBar progressIndicater = (ProgressBar)findViewById(R.id.listLoadprogressbar);
             progressIndicater.setVisibility(View.GONE);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
