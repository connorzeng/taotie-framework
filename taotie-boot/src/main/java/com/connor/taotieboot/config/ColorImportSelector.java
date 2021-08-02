package com.connor.taotieboot.config;

import com.connor.taotieboot.dto.Red;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ColorImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{Red.class.getName()};
    }
}
