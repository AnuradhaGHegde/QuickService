package com.android.quickservice.app.workermodel;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Abhay.27 on 8/18/2018.
 */

public class BaseWorkerModel implements Serializable {

    private String mWorkerName;

    private String mPhoneNumber;

    private Double mRating;

    private String mWorkerID;

    private String mAvailability;

    private String mAddress;

    private String mLabourRate;

    private String mTaxes;

    private String mDiscount;

    private String mServiceDesc;

    public String getmServiceDesc() {
        return mServiceDesc;
    }

    public void setmServiceDesc(String aServiceDesc) {
        this.mServiceDesc = aServiceDesc;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String aAddress) {
        this.mAddress = aAddress;
    }

    public String getmLabourRate() {
        return mLabourRate;
    }

    public void setmLabourRate(String aLabourRate) {
        this.mLabourRate = aLabourRate;
    }

    public String getmTaxes() {
        return mTaxes;
    }

    public void setmTaxes(String aTaxes) {
        this.mTaxes = aTaxes;
    }

    public String getmDiscount() {
        return mDiscount;
    }

    public void setmDiscount(String aDiscount) {
        this.mDiscount = aDiscount;
    }

    public String getmAvailability() {
        return mAvailability;
    }

    public void setmAvailability(String aAvailability) {
        this.mAvailability = aAvailability;
    }


    public String getmWorkerID() {
        return mWorkerID;
    }

    public void setmWorkerID(String aWorkerID) {
        this.mWorkerID = aWorkerID;
    }

    public String getmWorkerName() {
        return mWorkerName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public Double getmRating() {
        return mRating;
    }


    public void setmPhoneNumber(String aPhoneNumber) {
        this.mPhoneNumber = aPhoneNumber;
    }

    public void setmRating(Double aRating) {
        this.mRating = aRating;
    }

    public void setmWorkerName(String aWorkerName) {
        this.mWorkerName = aWorkerName;
    }

    public BaseWorkerModel() {

    }
}
