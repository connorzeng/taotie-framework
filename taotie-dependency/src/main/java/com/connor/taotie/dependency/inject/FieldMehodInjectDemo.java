package com.connor.taotie.dependency.inject;

import com.connor.taotie.dependency.annotation.ConnorPlanet;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * 字段和方法注入
 * 主要使用注解: @Resource @Autowired @Inject
 */
public class FieldMehodInjectDemo {

    private Persion persionFromMethod;


    /**
     * 限定符分组注入1-普通限定符
     */
    @Autowired
    @Qualifier("persion2")
    private Collection<Persion> qualifiedPersion2s;

    /**
     * 限定符分组注入1-普通限定符
     * 这里的默认限定符将读不到  @Qualifier("persion")
     */
    @Autowired
    @Qualifier
    private Collection<Persion> qualifiedPersions;

    /**
     * 限定符分组注入2-connor星球限定符
     */
    @Autowired
    @ConnorPlanet
    private Collection<Persion> connorPlanetPersions;


    @Autowired
    private Collection<Persion> persions;

    /**
     * 字段注入
     */
    @Autowired
    @Qualifier("persion")
    private Persion persionQualifier;

    /**
     * 字段注入
     */
    @Autowired
    @Qualifier("persion1")
    private Persion persionQualifier1;

    /**
     * 字段注入
     */
    @Autowired
    private Persion persion;

    /**
     * 方法注入
     * @param persion
     */
    @Autowired
    private void hello(Persion persion){
        this.persionFromMethod = persion;
    }


    @Bean
    @Qualifier("persion1")
    public Persion persionNormal1(){
        return new Persion("普通刚子一号,限定persion1111",1);
    }


    @Bean
    @Qualifier("persion2")//读取的时候也可以加value来限定,通beanName
    public Persion persionNormal2(){
        return new Persion("普通刚子二号,限定persion2222",1);
    }

    @Bean
    @ConnorPlanet
    public Persion persionConnorPlanet1(){
        return new Persion("connor星球刚子一号",1);
    }

    @Bean
    @ConnorPlanet
    public Persion persionConnorPlanet2(){
        return new Persion("connor星球刚子二号",1);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FieldMehodInjectDemo.class);
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");


        applicationContext.refresh();
        FieldMehodInjectDemo bean = applicationContext.getBean(FieldMehodInjectDemo.class);

        // 字段注入 == 方法注入
        System.out.println(bean.persion);
        System.out.println(bean.persionFromMethod);
        System.out.println(bean.persion == bean.persionFromMethod);

        // 注入集合
        System.out.println("------persions----");
        bean.persions.forEach(System.out::println);

        // 限定注入persionQualifier
        // 通过@Qualifier("persion")读取限定的beanName
        System.out.println("------persionQualifier----");
        System.out.println(bean.persionQualifier);

        // 限定注入persionQualifier11111111111
        // @Bean如果加了@Qualifier("persion1")限定
        // 注入时也可以加@Qualifier("persion1")读取单个
        System.out.println("------persionQualifier111111----");
        System.out.println(bean.persionQualifier1);


        // 注入集合分组
        // @Bean如果加了@Qualifier("persion2")限定
        // 注入时也可以加@Qualifier("persion2")读取集合
        System.out.println("------qualifiedPersions22222----");
        bean.qualifiedPersion2s.forEach(System.out::println);

        // 注入集合分组 这里的默认限定符将读不到  @Qualifier("persion")  @Qualifier("persion1")
        // 只能读到继承者 @ConnorPlanet
        System.out.println("------qualifiedPersions----");
        bean.qualifiedPersions.forEach(System.out::println);

        // 注入集合分组,注入connorPlanet分组
        // 只能读到@ConnorPlanet
        System.out.println("------connorPlanetPersions----");
        bean.connorPlanetPersions.forEach(System.out::println);


        applicationContext.close();
    }
}
