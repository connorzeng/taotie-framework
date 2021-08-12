package com.connor.taotieboot.annotation;


import com.connor.taotieboot.config.ColorConfig;
import com.connor.taotieboot.config.ColorImportBeanDefinitionRegistrar;
import com.connor.taotieboot.config.ColorImportSelector;
import com.connor.taotieboot.dto.Green;
import com.connor.taotieboot.dto.Red;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
//@Import({Green.class, Red.class, ColorConfig.class, ColorImportSelector.class})
@Import({ColorImportBeanDefinitionRegistrar.class})
public @interface EnableClolor {

}
