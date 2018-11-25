package com.ricky23.example.android.definitelynotlogin;

import java.io.Serializable;
import java.util.ArrayList;

public class Outlet implements Serializable {
    private String outletName;
    private String Address;
    private int openTimeInMinutes;
    private int closeTimeInMinutes;
    private ArrayList<Integer> openDay;
    private ArrayList<ProductType> types;
    private String imgUrl;

    public Outlet(String outletName, String address, int openTimeInMinutes, int closeTimeInMinutes, ArrayList<Integer> openDay, ArrayList<ProductType> types, String imgUrl) {
        this.outletName = outletName;
        Address = address;
        this.openTimeInMinutes = openTimeInMinutes;
        this.closeTimeInMinutes = closeTimeInMinutes;
        this.openDay = openDay;
        this.types = types;
        this.imgUrl = imgUrl;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getOpenTimeInMinutes() {
        return openTimeInMinutes;
    }

    public void setOpenTimeInMinutes(int openTimeInMinutes) {
        this.openTimeInMinutes = openTimeInMinutes;
    }

    public int getCloseTimeInMinutes() {
        return closeTimeInMinutes;
    }

    public void setCloseTimeInMinutes(int closeTimeInMinutes) {
        this.closeTimeInMinutes = closeTimeInMinutes;
    }

    public ArrayList<Integer> getOpenDay() {
        return openDay;
    }

    public void setOpenDay(ArrayList<Integer> openDay) {
        this.openDay = openDay;
    }

    public ArrayList<ProductType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<ProductType> types) {
        this.types = types;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
