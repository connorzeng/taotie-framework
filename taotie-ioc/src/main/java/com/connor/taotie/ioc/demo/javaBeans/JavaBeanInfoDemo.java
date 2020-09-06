package com.connor.taotie.ioc.demo.javaBeans;


import com.connor.taotie.ioc.pojo.Persion;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo}  使用示例
 */
public class JavaBeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {

        // 内省器
        BeanInfo beanInfo = Introspector.getBeanInfo(Persion.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            //java.beans.PropertyDescriptor[name=age; propertyType=class java.lang.Integer; readMethod=public java.lang.Integer com.connor.pojo.Persion.getAge(); writeMethod=public void com.connor.pojo.Persion.setAge(java.lang.Integer)]
            //java.beans.PropertyDescriptor[name=name; propertyType=class java.lang.String; readMethod=public java.lang.String com.connor.pojo.Persion.getName(); writeMethod=public void com.connor.pojo.Persion.setName(java.lang.String)]
            System.out.println(propertyDescriptor.toString());
        });


    }
}
