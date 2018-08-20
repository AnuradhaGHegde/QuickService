package com.android.quickservice.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.android.quickservice.app.workermodel.BaseWorkerModel;

import java.util.ArrayList;

/**
 * Created by Abhay.27 on 8/18/2018.
 */
public class ServiceListCustomAdapter extends BaseAdapter {

    Context context;
    BaseServiceModel mServiceModel;
    ArrayList<BaseWorkerModel> mWorkerModelList;
    public ServiceListCustomAdapter(Context context, BaseServiceModel  serviceModel) {
        this.context = context;
        this.mServiceModel = serviceModel;
        mWorkerModelList =(ArrayList<BaseWorkerModel>) this.mServiceModel.getmWorkerList();
    }

    @Override
    public int getCount() {
        return mWorkerModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return mWorkerModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = null;
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.view_worker_list_item, null);

            TextView tvWorkerName = (TextView) view.findViewById(R.id.workerNameTxtVw);
            TextView tvDescription = (TextView) view.findViewById(R.id.servicedescriptionTxtVw);
            TextView tvRating = (TextView) view.findViewById(R.id.workerRatingTxtVw);

            BaseWorkerModel worker = mWorkerModelList.get(i);
            tvWorkerName.setText(worker.getmWorkerName());
            tvDescription.setText(worker.getmServiceDesc());

            tvRating.setText(Double.toString(worker.getmRating())+"/5");
        }
        return view;
    }
}
