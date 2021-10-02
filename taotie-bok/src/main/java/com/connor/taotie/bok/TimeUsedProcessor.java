package com.connor.taotie.bok;

import com.connor.taotie.bok.annotation.TimeUsed;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.util.LinkedHashSet;
import java.util.Set;


/**&
 * <!-- java SPI自动注册 -->
 * <!-- 自动注册注解库,注册注解处理器到META-INFO/services/javax.annotation.processing.Processor -->
 */
@AutoService(Processor.class)
public class TimeUsedProcessor extends AbstractProcessor {


    private Messager messager; //用于打印日志
    private Elements elementUtils; //用于处理元素,元
    private Filer filer;  //用来创建java文件或者class文件


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        messager.printMessage(Diagnostic.Kind.NOTE,"-----MyProcessor 开始自动生成源代码");




        return false;
    }


    //不过，考虑到兼容性，我建议重写getSupportedAnnotationTypes()和getSupportedSourceVersion()而不是使用@SupportedAnnotationTypes和@SupportedSourceVersion这两个注解
    /**
     * 返回需要支持的注解类型,可以使用注解的方式实现
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> annotationTypes = new LinkedHashSet<>();
        annotationTypes.add(TimeUsed.class.getCanonicalName());

        return annotationTypes;
    }


    /**
     * 返回支持的java版本,可以使用注解的方式实现
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {

        //支持JDK8
        return SourceVersion.RELEASE_8;
    }
}
