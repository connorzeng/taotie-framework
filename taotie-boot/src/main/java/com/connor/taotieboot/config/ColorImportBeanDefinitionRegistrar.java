package com.connor.taotieboot.config;

import com.connor.taotieboot.dto.Black;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 *  @see Import
 *  @see ImportSelector
 *  @see ImportBeanDefinitionRegistrar
 */
public class ColorImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        registry.registerBeanDefinition("black", new RootBeanDefinition(Black.class));
    }
}
