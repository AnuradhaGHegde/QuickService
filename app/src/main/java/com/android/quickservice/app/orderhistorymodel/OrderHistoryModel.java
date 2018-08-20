package com.android.quickservice.app.orderhistorymodel;

import com.android.quickservice.app.workermodel.BaseWorkerModel;

import java.io.Serializable;

/**
 * Created by Abhay.27 on 8/19/2018.
 */

public class OrderHistoryModel implements Serializable {

    private String mOrderObjectID;

    public String getmOrderID() {
        return mOrderID;
    }

    public void setmOrderID(String aOrderID) {
        this.mOrderID = aOrderID;
    }

    public String getmOrderObjectID() {
        return mOrderObjectID;
    }

    public void setmOrderObjectID(String aOrderObjectID) {
        this.mOrderObjectID = aOrderObjectID;
    }

    private String mOrderID;
    private BaseWorkerModel mWorkerModel;
    private long mOrderDate;
    private PAYMENT_STATE mPaymentState;

    public BaseWorkerModel getmWorkerModel() {
        return mWorkerModel;
    }

    public void setmWorkerModel(BaseWorkerModel aWorkerModel) {
        this.mWorkerModel = aWorkerModel;
    }

    public long getOrderDate() {
        return mOrderDate;
    }

    public void setOrderDate(long aOrderDate) {
        mOrderDate = aOrderDate;
    }

    public PAYMENT_STATE getPaymentState() {
        return mPaymentState;
    }

    public void setPaymentState(PAYMENT_STATE aPaymentState) {
        mPaymentState = aPaymentState;
    }

}
