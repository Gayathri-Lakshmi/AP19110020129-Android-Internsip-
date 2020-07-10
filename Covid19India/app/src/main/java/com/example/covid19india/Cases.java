package com.example.covid19india;

public class Cases  {
    private String date,active,recovered,deaths;

    public Cases(String d,String a,String r,String de){

        date=d;
        active=a;
        recovered=r;
        deaths=de;

    }


    public String getDate() {
        return date.substring ( 0,10 );
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
