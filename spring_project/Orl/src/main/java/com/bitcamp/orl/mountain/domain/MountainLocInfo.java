package com.bitcamp.orl.mountain.domain;

public class MountainLocInfo {
    private String mountainName;
    private String mountainCode;
    private String mountainAddress;
    private double latitude;
    private double longitude;
    private String mountainInfo;
    private int height;
    private String mountainDetailInfo;
    private String transport;
    private String img;

    public MountainLocInfo(String mountainName, String mountainCode, String mountainAddress, double latitude, double longitude, String mountainInfo, int height, String mountainDetailInfo, String transport, String img) {

        this.mountainName = mountainName;
        this.mountainCode = mountainCode;
        this.mountainAddress = mountainAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mountainInfo = mountainInfo;
        this.height = height;
        this.mountainDetailInfo = mountainDetailInfo;
        this.transport = transport;
        this.img = img;
    }

    public String getMountainName() {
        return mountainName;
    }

    public void setMountainName(String mountainName) {
        this.mountainName = mountainName;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountainAddress() {
        return mountainAddress;
    }

    public void setMountainAddress(String mountainAddress) {
        this.mountainAddress = mountainAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMountainInfo() {
        return mountainInfo;
    }

    public void setMountainInfo(String mountainInfo) {
        this.mountainInfo = mountainInfo;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMountainDetailInfo() {
        return mountainDetailInfo;
    }

    public void setMountainDetailInfo(String mountainDetailInfo) {
        this.mountainDetailInfo = mountainDetailInfo;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "MountainLocInfo{" +
                "mountainName='" + mountainName + '\'' +
                ", mountainCode='" + mountainCode + '\'' +
                ", mountainAddress='" + mountainAddress + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mountainInfo='" + mountainInfo + '\'' +
                ", height=" + height +
                ", mountainDetailInfo='" + mountainDetailInfo + '\'' +
                ", transport='" + transport + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
