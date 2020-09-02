package com.connor.taotie.ioc.pojo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用来注入Persion
 */
public class PersionRepository {

    // 自定义 Bean
    private Collection<Persion> persions;

    // 内建对象
    private BeanFactory beanFactory;

    // objectFactory(还不知道是)
    private ObjectFactory<ApplicationContext> objectFactory;


    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<Persion> getPersions() {
        return persions;
    }

    public void setPersions(Collection<Persion> persions) {
        this.persions = persions;
    }

    @Override
    public String toString() {
        return "PersionRepository{" +
                "persions=" + persions +
                "\r\nbeanFactory=" + beanFactory +
                "\r\nobjectFactory=" + objectFactory +
                '}';
    }
}
