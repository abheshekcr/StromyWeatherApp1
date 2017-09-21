package com.example.welcome.stromyweatherapp.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by welcome on 9/20/2017.
 */

public class Hour implements Parcelable {
    private long mTime;
    private String mSummary;
    private double mTemperatue;
    private String mIcon;
    private String mTimeZone;

    protected Hour(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemperatue = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }

    public Hour(){

    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel in) {
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperatue() {
        return (int) Math.round(mTemperatue);
    }

    public void setTemperatue(double temperatue) {
        mTemperatue = temperatue;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId(){
        return  Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public String getHour(){
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(mTime*1000);
        return  formatter.format(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mTime);
        parcel.writeString(mSummary);
        parcel.writeDouble(mTemperatue);
        parcel.writeString(mIcon);
        parcel.writeString(mTimeZone);
    }
}
