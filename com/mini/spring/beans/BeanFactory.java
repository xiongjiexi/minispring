package com.mini.spring.beans;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException, RuntimeException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
