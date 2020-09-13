package com.connor.taotie.dependency.pojo;


import com.connor.taotie.ioc.pojo.Persion;

/**
 * 用来测试注解
 */
public class PersionHolder {

    private Persion persion;


    public Persion getPersion() {
        return persion;
    }

    public void setPersion(Persion persion) {
        this.persion = persion;
    }

    @Override
    public String toString() {
        return "PersionHolder{" +
                "persion=" + persion +
                '}';
    }
}
