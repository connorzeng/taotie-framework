package com.connor.taotieboot.annotation;


import com.connor.taotieboot.config.ColorConfig;
import com.connor.taotieboot.config.ColorImportBeanDefinitionRegistrar;
import com.connor.taotieboot.config.ColorImportSelector;
import com.connor.taotieboot.dto.Green;
import com.connor.taotieboot.dto.Red;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Import({Green.class, Red.class, ColorConfig.class, ColorImportSelector.class})
//@Import({ColorImportBeanDefinitionRegistrar.class})
public @interface EnableClolor {

}
