package com.Fun;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  
public class MvcConfigurer extends WebMvcConfigurerAdapter {  
  
    @Override  
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/TeacherPage").setViewName("Teacher.html");
        registry.addViewController("/StudentPage").setViewName("Student.html");
        registry.addViewController("/QuestionsPage").setViewName("Questions.html");
        registry.addViewController("/NewQuestionsPage").setViewName("NewQuestions.html");
        registry.addViewController("/HomePage").setViewName("index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);  
    }
  
    @Override  
    public void configurePathMatch(PathMatchConfigurer configurer) {  
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);  
    }  
  
  
}  
