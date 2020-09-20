package com.connor.common.constants;

/**
 * 城市的枚举
 */
public enum City {

    Wuhan("武汉","Wuhan"),
    Shenzhen("深圳","Shenzhen"),
    Guangzhou("广州","Guangzhou");

    private String  cityName;
    private String  cityCode;

    City(String cityName, String cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                "} " + super.toString();
    }
}
