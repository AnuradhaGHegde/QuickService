package com.android.quickservice.app.servicemodel;

import com.android.quickservice.app.workermodel.*;

import java.util.List;

/**
 * Created by Abhay.27 on 8/18/2018.
 */

public class BaseServiceModel {

    private String mServiceName;

    private List<BaseWorkerModel> mWorkerList;

    private SERVICE_TYPE mServiceType;

    private String mServiceUID;

    public BaseServiceModel() {

    }

    public String getmServiceUID() {
        return mServiceUID;
    }

    public void setmServiceUID(String aServiceUID) {
        this.mServiceUID = aServiceUID;
    }

    public List<BaseWorkerModel> getmWorkerList() {
        return mWorkerList;
    }

    public void setmWorkerList(List<BaseWorkerModel> mWorkerList) {
        this.mWorkerList = mWorkerList;
    }

    public String getmServiceName() {
        return mServiceName;
    }

    public void setmServiceName(String mServiceName) {
        this.mServiceName = mServiceName;
    }

    public SERVICE_TYPE getmServiceType() {
        return mServiceType;
    }

    public void setmServiceType(SERVICE_TYPE mServiceType) {
        this.mServiceType = mServiceType;
    }

}

