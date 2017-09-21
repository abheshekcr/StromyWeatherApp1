package com.example.welcome.stromyweatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcome.stromyweatherapp.R;
import com.example.welcome.stromyweatherapp.weather.Day;

/**
 * Created by welcome on 9/20/2017.
 */

public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context,Day[] days){
        mContext=context;
        mDays=days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item,null);
            holder = new ViewHolder();
            holder.imgTempCircle = (ImageView) view.findViewById(R.id.circleImageView);
            holder.iconImageView = (ImageView) view.findViewById(R.id.iconImageView);
            holder.dayLabel = (TextView) view.findViewById(R.id.dayNameLabel);
            holder.temperatureLabel = (TextView) view.findViewById(R.id.tempLabel);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Day day = mDays[i];
        holder.imgTempCircle.setImageResource(R.drawable.bg_temperature);
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax()+"");
        holder.dayLabel.setText(day.getDayOftheWeek());
        return view;
    }

    public static class ViewHolder{
        ImageView imgTempCircle;
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
