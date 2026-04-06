package com.mini.spring.context;

import com.mini.spring.beans.BeanDefinition;
import com.mini.spring.beans.BeanFactory;
import com.mini.spring.beans.BeansException;
import com.mini.spring.beans.SimpleBeanFactory;
import com.mini.spring.core.ApplicationEvent;
import com.mini.spring.core.ApplicationEventPublisher;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {
    SimpleBeanFactory simpleBeanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        this.simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.simpleBeanFactory);
        reader.loadBeanDefinitions(resource);
    }

    @Override
    public Object getBean(String beanName) throws BeansException, RuntimeException {
        return this.simpleBeanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.simpleBeanFactory.containsBean(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.simpleBeanFactory.registerBean(beanName, obj);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name) {
        return null;
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
    }
}
