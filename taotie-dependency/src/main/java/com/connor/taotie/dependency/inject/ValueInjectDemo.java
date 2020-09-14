package com.connor.taotie.dependency.inject;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.PropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Properties;

public class ValueInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ValueInjectDemo.class);
        configApplicationContext.refresh();


        System.out.println(configApplicationContext.getBean("pojo"));

        configApplicationContext.close();
    }


    public class PropertyUtil extends PropertySourcesPlaceholderConfigurer {

        /**
         * Return a merged Properties instance containing both the
         * loaded properties and properties set on this FactoryBean.
         */
        protected Properties mergeProperties() throws IOException {
            Properties properties = super.mergeProperties();

            //添加私货
            properties.put("connorzeng","刚子老师的私货");

            return properties;
        }
    }

    @Bean
    public PropertyUtil propertyUtil(){
        return new PropertyUtil();
    }

    @Bean
    public Pojo pojo() {
        return new Pojo();
    }


    static class Pojo {

        // 系统用户:connor
        @Value("${userName}")
        private String userName;

        // 系统用户:connor
        @Value("${connorzeng}")
        private String connorzeng;

        @Override
        public String toString() {
            return "Pojo{" +
                    "userName='" + userName + '\'' +
                    ", connorzeng='" + connorzeng + '\'' +
                    '}';
        }
    }


}
