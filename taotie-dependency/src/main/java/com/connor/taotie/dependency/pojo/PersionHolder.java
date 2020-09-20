package com.connor.taotie.dependency.pojo;


import com.connor.common.constants.City;
import com.connor.taotie.ioc.pojo.Persion;

import java.util.Arrays;
import java.util.List;

/**
 * 用来测试注解
 */
public class PersionHolder {

    private Persion persion;

    // 测试注入List
    private List<Persion> persionList;
    // 测试注入Array
    private Persion[] persionArray;

    private City[] cityArray;

    /**
     * 构造器自动注入不能使用byName  只有byType
     * @param superPersion
     */
    public PersionHolder(Persion superPersion) {
        this.persion = superPersion;
    }
    public PersionHolder() {
    }

    public City[] getCityArray() {
        return cityArray;
    }

    public void setCityArray(City[] cityArray) {
        this.cityArray = cityArray;
    }

    public Persion getPersion() {
        return persion;
    }

    public void setPersion(Persion persion) {
        this.persion = persion;
    }


    public List<Persion> getPersionList() {
        return persionList;
    }

    public void setPersionList(List<Persion> persionList) {
        this.persionList = persionList;
    }

    public Persion[] getPersionArray() {
        return persionArray;
    }

    public void setPersionArray(Persion[] persionArray) {
        this.persionArray = persionArray;
    }

    @Override
    public String toString() {
        return "PersionHolder{" +
                "persion=" + persion +
                ", persionList=" + persionList +
                ", persionArray=" + Arrays.toString(persionArray) +
                ", cityArray=" + Arrays.toString(cityArray) +
                '}';
    }
}
