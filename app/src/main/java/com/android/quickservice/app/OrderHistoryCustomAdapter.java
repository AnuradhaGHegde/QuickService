package com.android.quickservice.app;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.quickservice.app.orderhistorymodel.OrderHistoryModel;
import com.android.quickservice.app.servicemodel.BaseServiceModel;
import com.android.quickservice.app.workermodel.BaseWorkerModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abhay.27 on 8/19/2018.
 */

public class OrderHistoryCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<OrderHistoryModel> mOrderHistoryList;

    public OrderHistoryCustomAdapter(Context context, ArrayList<OrderHistoryModel>  orderHistoryList) {
        this.context = context;
        mOrderHistoryList =orderHistoryList;
    }


    @Override
    public int getCount() {
        return mOrderHistoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return mOrderHistoryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = null;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.order_history_item, null);

            TextView tvWorkerName = (TextView) convertView.findViewById(R.id.workerNameTxtVw);
            TextView tvDescription = (TextView) convertView.findViewById(R.id.servicetypeTxtVw);
            TextView tvserviceDate = (TextView) convertView.findViewById(R.id.serviceDateTxtVw);
            TextView tvPaymentState = (TextView) convertView.findViewById(R.id.paymentStateTxtVw);

            OrderHistoryModel order = mOrderHistoryList.get(position);
            tvWorkerName.setText(order.getmWorkerModel().getmWorkerName());
            tvDescription.setText(order.getmWorkerModel().getmServiceDesc());
            tvserviceDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date(order.getOrderDate())));

            if(order.getPaymentState().toString().equals("PENDING"))
            {
                tvPaymentState.setTextColor(ContextCompat.getColor(context,R.color.text_color_black_color_red));
            }
            else if(order.getPaymentState().toString().equals("CANCELLED"))
            {
                tvPaymentState.setTextColor(ContextCompat.getColor(context,R.color.black_overlay));
            }
            else if(order.getPaymentState().toString().equals("COMPLETED"))
            {
                tvPaymentState.setTextColor(ContextCompat.getColor(context,R.color.text_color_black_color_green));
            }
            tvPaymentState.setText(order.getPaymentState().toString());
        }

        return convertView;
    }
}
