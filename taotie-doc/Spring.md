
# Spring内建对象

```json
{
    "environment":"org.springframework.core.env.StandardEnvironment",
    "systemProperties":"java.util.Properties",
    "systemEnvironment":"java.util.Collections$UnmodifiableMap",
    "messageSource":"org.springframework.context.support.DelegatingMessageSource",
    "applicationEventMulticaster":"org.springframework.context.event.SimpleApplicationEventMulticaster",
    "lifecycleProcessor":"org.springframework.context.support.DefaultLifecycleProcessor",
    "objectFactory":"org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean$TargetBeanObjectFactory"
}
```

AnnotationConfigUtils

|  bean名称   | bean实例  |使用场景  |
|  ----  | ----  |----  |
|   | ConfigurationClassPostProcessor |处理Spring配置类 |
|   | AutowiredAnnotationBeanPostProcessor |处理@Autowired @Value |
|   | CommonAnnotationBeanPostProcessor |(条件激活)处理JSR-250  @PostConstruct |
|   | EventListenerMethodProcessor | @EventListener |
|   | DefaultEventListenerFactory | 为@EventListener 事件监听方法适配为ApplicationListener |






