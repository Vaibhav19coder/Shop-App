package com.example.shopprofit;

public class DataStore {
    String iname;
    String pkey;

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public DataStore(String iname, String weight, String cp, String sp, String pkey) {
        this.iname = iname;
        this.weight = weight;
        this.cp = cp;
        this.sp = sp;
        this.pkey=pkey;
    }

    public String getIname() {
        return iname;
    }

    public DataStore() {
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getWeight() {
        return weight;
    }

    public String getCp() {
        return cp;
    }

    public String getSp() {
        return sp;
    }

    String weight;
    String cp;
    String sp;
}
