package com.mini.spring;

import com.mini.spring.beans.BeanFactory;
import com.mini.spring.beans.BeansException;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.SimpleBeanFactory;
import com.mini.spring.core.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        this.beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.beanFactory);
        reader.loadBeanDefinitions(resource);
    }

    @Override
    public Object getBean(String beanName) throws BeansException, RuntimeException {
        return this.beanFactory.getBean(beanName);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

}
