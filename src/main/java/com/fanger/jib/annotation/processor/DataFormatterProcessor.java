package com.fanger.jib.annotation.processor;

import com.fanger.jib.annotation.DateFormatter;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.fanger.jib.annotation.DateFormatter"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DataFormatterProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Elements elements = processingEnv.getElementUtils();
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "this is log.");
        System.out.println("this is log.");
        return true;
    }
}
