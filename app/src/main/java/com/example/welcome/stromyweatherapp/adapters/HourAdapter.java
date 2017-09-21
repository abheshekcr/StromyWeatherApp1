package com.example.welcome.stromyweatherapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.welcome.stromyweatherapp.R;
import com.example.welcome.stromyweatherapp.weather.Hour;

/**
 * Created by welcome on 9/21/2017.
 */

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>{

    private Hour[] mHours;
    private Context mContext;



    public HourAdapter( Context contexts ,Hour[] hours){
        mHours=hours;
        mContext=contexts;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item,parent,false);
        HourViewHolder hourViewHolder = new HourViewHolder(view);

        return hourViewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.BindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void BindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperatue()+"");
            mIconImageView.setImageResource(hour.getIconId());

        }

        @Override
        public void onClick(View view) {
            String time=mTimeLabel.getText().toString();
            String temperature=mTemperatureLabel.getText().toString();
            String summary=mSummaryLabel.getText().toString();

            String message= String .format("At %s it will be %s and %s",
                    time,
                    temperature,
                    summary);
            Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
        }
    }


}
