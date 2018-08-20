package com.android.quickservice.app;

import android.support.annotation.NonNull;

import com.android.quickservice.app.orderhistorymodel.OrderHistoryModel;
import com.android.quickservice.app.orderhistorymodel.PAYMENT_STATE;
import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.android.quickservice.app.servicemodel.SERVICE_TYPE;
import com.android.quickservice.app.workermodel.BaseWorkerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Abhay.27 on 8/18/2018.
 */

public class FireBaseHelper implements ValueEventListener {
    private DatabaseReference mDatabaseRootRef;
    BaseServiceModel mServiceModel;

    public FireBaseHelper() {
        this.mDatabaseRootRef = FirebaseDatabase.getInstance().getReference();
        mServiceModel = new BaseServiceModel();
        DatabaseReference childref = mDatabaseRootRef.child("Services");
        childref.addValueEventListener(this);
    }


    public void writeToFirebase()
    {
       CreateElectricalWorkerData();
       CreateElectronicWorkerData();

        //CreateOrderHistoryData();
    }

    private void CreateOrderHistoryData() {

        OrderHistoryModel order1 = new OrderHistoryModel();
        order1.setmOrderObjectID(mDatabaseRootRef.child("QuickServiceDB/OrderHistory").push().getKey());
        BaseWorkerModel workerModel = new BaseWorkerModel();
        workerModel.setmAvailability("Available");
        workerModel.setmPhoneNumber("+91000001110");
        workerModel.setmRating(3.5);
        workerModel.setmWorkerID("EI-1126");
        workerModel.setmWorkerName("Bob");
        workerModel.setmAvailability("Available");
        workerModel.setmAddress("56thstreet,Kengeri, Bangalore");
        workerModel.setmDiscount("0");
        workerModel.setmLabourRate("200");
        workerModel.setmTaxes("10");
        workerModel.setmServiceDesc("Fans, Mixers,toaster repairs");

        order1.setmWorkerModel(workerModel);
        order1.setOrderDate(System.currentTimeMillis());
        order1.setPaymentState(PAYMENT_STATE.PENDING);
        order1.setmOrderID("OrderID-1132");
        mDatabaseRootRef.child("QuickServiceDB/OrderHistory").child(order1.getmOrderObjectID()).setValue(order1);

        OrderHistoryModel order2 = new OrderHistoryModel();
        order2.setmOrderObjectID(mDatabaseRootRef.child("QuickServiceDB/OrderHistory").push().getKey());
        BaseWorkerModel workerModel1 = new BaseWorkerModel();
        workerModel1.setmAvailability("Available");
        workerModel1.setmPhoneNumber("+91000001110");
        workerModel1.setmRating(3.5);
        workerModel1.setmWorkerID("EI-1126");
        workerModel1.setmWorkerName("Bob");
        workerModel1.setmAvailability("Available");
        workerModel1.setmAddress("56thstreet,Kengeri, Bangalore");
        workerModel1.setmDiscount("0");
        workerModel1.setmLabourRate("200");
        workerModel1.setmTaxes("10");
        workerModel1.setmServiceDesc("Fans, Mixers,toaster repairs");

        order2.setmWorkerModel(workerModel1);
        order2.setOrderDate(System.currentTimeMillis());
        order2.setPaymentState(PAYMENT_STATE.COMPLETED);
        order2.setmOrderID("OrderID-1132");
        mDatabaseRootRef.child("QuickServiceDB/OrderHistory").child(order2.getmOrderObjectID()).setValue(order2);

        OrderHistoryModel order3 = new OrderHistoryModel();
        order3.setmOrderObjectID(mDatabaseRootRef.child("QuickServiceDB/OrderHistory").push().getKey());
        BaseWorkerModel workerModel3 = new BaseWorkerModel();
        workerModel3.setmAvailability("Available");
        workerModel3.setmPhoneNumber("+91000001110");
        workerModel3.setmRating(3.5);
        workerModel3.setmWorkerID("EI-1126");
        workerModel3.setmWorkerName("Bob");
        workerModel3.setmAvailability("Available");
        workerModel3.setmAddress("56thstreet,Kengeri, Bangalore");
        workerModel3.setmDiscount("0");
        workerModel3.setmLabourRate("200");
        workerModel3.setmTaxes("10");
        workerModel3.setmServiceDesc("Fans, Mixers,toaster repairs");

        order3.setmWorkerModel(workerModel1);
        order3.setOrderDate(System.currentTimeMillis());
        order3.setPaymentState(PAYMENT_STATE.COMPLETED);
        order3.setmOrderID("OrderID-1132");
        mDatabaseRootRef.child("QuickServiceDB/OrderHistory").child(order3.getmOrderObjectID()).setValue(order3);


    }

    private void CreateElectronicWorkerData() {
        BaseServiceModel serviceModel1 = new BaseServiceModel();
        serviceModel1.setmServiceUID(mDatabaseRootRef.child("QuickServiceDB/Services").push().getKey());
        serviceModel1.setmServiceName("Electronic");
        serviceModel1.setmServiceType(SERVICE_TYPE.Electronic);

        BaseWorkerModel workerModel1 = new BaseWorkerModel();
      //  workerModel1.setmObjectID(mDatabaseRootRef.child("Services").child(serviceModel1.getmServiceUID()).push().getKey());
        workerModel1.setmAvailability("Available");
        workerModel1.setmPhoneNumber("+910044001110");
        workerModel1.setmRating(4.0);
        workerModel1.setmWorkerID("EO-1136");
        workerModel1.setmWorkerName("David");
        workerModel1.setmAddress("58thstreet,Malad, Mumbai");
        workerModel1.setmDiscount("10");
        workerModel1.setmLabourRate("300");
        workerModel1.setmTaxes("13");
        workerModel1.setmServiceDesc("Fridge,AC repairs");

        BaseWorkerModel workerModel12 = new BaseWorkerModel();
       // workerModel1.setmObjectID(mDatabaseRootRef.child("Services").child(serviceModel1.getmServiceUID()).push().getKey());
        workerModel12.setmAvailability("Available");
        workerModel12.setmPhoneNumber("+910044001110");
        workerModel12.setmRating(3.5);
        workerModel12.setmWorkerID("EO-1156");
        workerModel12.setmWorkerName("Stewart");
        workerModel12.setmAddress("58thstreet,Malad, Mumbai");
        workerModel12.setmDiscount("10");
        workerModel12.setmLabourRate("300");
        workerModel12.setmTaxes("13");
        workerModel12.setmServiceDesc("Computers,mobile repairs");


        BaseWorkerModel workerModel3 = new BaseWorkerModel();
        //workerModel1.setmObjectID(mDatabaseRootRef.child("Services").child(serviceModel1.getmServiceUID()).push().getKey());
        workerModel3.setmAvailability("Available");
        workerModel3.setmPhoneNumber("+910044001110");
        workerModel3.setmRating(2.0);
        workerModel3.setmWorkerID("EO-1146");
        workerModel3.setmWorkerName("Finn");
        workerModel3.setmAddress("58thstreet,Malad, Mumbai");
        workerModel3.setmDiscount("10");
        workerModel3.setmLabourRate("300");
        workerModel3.setmTaxes("13");
        workerModel3.setmServiceDesc("TV repairs");

        ArrayList<BaseWorkerModel> workerlist1 = new ArrayList<>();
        workerlist1.add(workerModel12);
        workerlist1.add(workerModel1);
        workerlist1.add(workerModel3);
        serviceModel1.setmWorkerList(workerlist1);
        mDatabaseRootRef.child("QuickServiceDB/Services").child(serviceModel1.getmServiceUID()).setValue(serviceModel1);


    }

    private void CreateElectricalWorkerData() {
        BaseServiceModel serviceModel = new BaseServiceModel();
        serviceModel.setmServiceUID(mDatabaseRootRef.child("QuickServiceDB/Services").push().getKey());
        serviceModel.setmServiceName("Electrical");
        serviceModel.setmServiceType(SERVICE_TYPE.Electrical);

        BaseWorkerModel workerModel = new BaseWorkerModel();
        workerModel.setmAvailability("Available");
        workerModel.setmPhoneNumber("+91000001110");
        workerModel.setmRating(3.5);
        workerModel.setmWorkerID("EI-1126");
        workerModel.setmWorkerName("Bob");
        workerModel.setmAvailability("Available");
        workerModel.setmAddress("56thstreet,Kengeri, Bangalore");
        workerModel.setmDiscount("0");
        workerModel.setmLabourRate("200");
        workerModel.setmTaxes("10");
        workerModel.setmServiceDesc("Fans, Mixers,toaster repairs");


        BaseWorkerModel workerModel11 = new BaseWorkerModel();
        workerModel11.setmAvailability("Available");
        workerModel11.setmPhoneNumber("+91000001110");
        workerModel11.setmRating(3.5);
        workerModel11.setmWorkerID("EI-1127");
        workerModel11.setmWorkerName("James");
        workerModel11.setmAvailability("Available");
        workerModel11.setmAddress("50thstreet,Banaswadi, Bangalore");
        workerModel11.setmDiscount("0");
        workerModel11.setmLabourRate("200");
        workerModel11.setmTaxes("10");
        workerModel11.setmServiceDesc("All electrical repairs");

        BaseWorkerModel workerModel12 = new BaseWorkerModel();
        workerModel12.setmAvailability("Available");
        workerModel12.setmPhoneNumber("+91000001110");
        workerModel12.setmRating(3.5);
        workerModel12.setmWorkerID("EI-1123");
        workerModel12.setmWorkerName("Charles");
        workerModel12.setmAvailability("Available");
        workerModel12.setmAddress("59thstreet,Banashankari, Bangalore");
        workerModel12.setmDiscount("0");
        workerModel12.setmLabourRate("200");
        workerModel12.setmTaxes("10");
        workerModel12.setmServiceDesc("All electrical repairs");


        ArrayList<BaseWorkerModel> workerlist = new ArrayList<>();
        workerlist.add(workerModel);
        workerlist.add(workerModel11);
        workerlist.add(workerModel12);
        serviceModel.setmWorkerList(workerlist);
        mDatabaseRootRef.child("QuickServiceDB/Services").child(serviceModel.getmServiceUID()).setValue(serviceModel);
    }

    public void readFromFireBase()
    {

    }

    public void deleteFromFireBase()
    {

    }

    public void updateFirebase()
    {

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
