package com.example.welcome.stromyweatherapp.weather;

import com.example.welcome.stromyweatherapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by welcome on 9/19/2017.
 */

public class Current {
    private String mIcon;
    private long mTime;
    private double mTemp;
    private double mhumidity;
    private double mPrecipChance;
    private String mSummary;
    private String mTimeZone;

    public double getMhumidity() {
        return mhumidity;
    }

    public void setMhumidity(double mhumidity) {
        this.mhumidity = mhumidity;
    }

    public String getTimeZone() {

        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getFormattedTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime()*1000);
        String timeString = formatter.format(dateTime );

        return timeString;
    }

    public int getTemp() {
        return (int) Math.round(mTemp);
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }




    public int getPrecipChance() {
        double precipPercent = mPrecipChance*100;
        return (int)Math.round(precipPercent);
    }

    public void setPrecipChance(double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
