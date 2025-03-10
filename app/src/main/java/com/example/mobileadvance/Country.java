package com.example.mobileadvance;

public class Country {
    // Các thuộc tính của lớp Country
    private String name;
    private String capital;
    private String region;

    // Constructor để khởi tạo một đối tượng Country
    public Country(String name, String capital, String region) {
        this.name = name;
        this.capital = capital;
        this.region = region;
    }

    // Phương thức getter để lấy tên của quốc gia
    public String getName() {
        return name;
    }

    // Phương thức getter để lấy thủ đô của quốc gia
    public String getCapital() {
        return capital;
    }

    // Phương thức getter để lấy khu vực của quốc gia
    public String getRegion() {
        return region;
    }

    // Phương thức toString để hiển thị thông tin của quốc gia dưới dạng chuỗi
    @Override
    public String toString() {
        return name + " - Capital: " + capital + ", Region: " + region;
    }
}