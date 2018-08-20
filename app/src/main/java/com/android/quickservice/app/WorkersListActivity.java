package com.android.quickservice.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.android.quickservice.app.servicemodel.SERVICE_TYPE;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WorkersListActivity extends AppCompatActivity implements ValueEventListener {

    BaseServiceModel mServiceModel;
    ServiceListCustomAdapter customAdapter;
    ListView listView;
    SERVICE_TYPE mServiceType;
    private DatabaseReference mDatabaseRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers_list);

        ProgressBar progressIndicater = (ProgressBar)findViewById(R.id.listLoadprogressbar);
        progressIndicater.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        mServiceType =(SERVICE_TYPE) intent.getSerializableExtra("SERVICE_TYPE");
        setTitle(mServiceType.toString()+" Workers");

        listView = (ListView) findViewById(R.id.workerListView);

        this.mDatabaseRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference childref = mDatabaseRootRef.child("QuickServiceDB/Services");
        childref.addValueEventListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(WorkersListActivity.this, WorkerDetailViewActivity.class);
                intent.putExtra("Worker_Data",WorkersListActivity.this.mServiceModel.getmWorkerList().get(i));
                intent.putExtra("Service_ID",WorkersListActivity.this.mServiceModel.getmServiceUID());
                intent.putExtra("worker_data_pos",Integer.toString(i));
                startActivity(intent);
            }
        });

    }

      @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       //long count=   dataSnapshot.child("QuickServiceDB/Services").getValue();
        for (DataSnapshot messageSnapshot:   dataSnapshot.getChildren()) {

            mServiceModel = messageSnapshot.getValue(BaseServiceModel.class);
            if(mServiceType== mServiceModel.getmServiceType())
            {
                mServiceModel = messageSnapshot.getValue(BaseServiceModel.class);
                customAdapter = new ServiceListCustomAdapter(getApplicationContext(), mServiceModel);
                listView.setAdapter(customAdapter);
                ProgressBar progressIndicater = (ProgressBar)findViewById(R.id.listLoadprogressbar);
                progressIndicater.setVisibility(View.GONE);
                break;
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
