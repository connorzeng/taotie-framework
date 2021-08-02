package com.connor.taotieboot.annotation;


import com.connor.taotieboot.config.ColorImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
//@Import({Green.class, Red.class, ColorConfig.class, ColorImportSelector.class})
//@Import({ColorImportBeanDefinitionRegistrar.class})
public @interface EnableClolor {

}
