package com.mini.spring.context;

import com.mini.spring.beans.*;
import org.dom4j.Element;

import java.util.List;

public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);

            List<Element> propertyElements = element.elements("property");
            PropertyValues pvs = new PropertyValues();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                pvs.addPropertyValue(pType, pName, pValue);
            }
            beanDefinition.setPropertyValues(pvs);

            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues avs = new ArgumentValues();
            for (Element e : constructorElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                avs.addArgumentValue(new ArgumentValue(pValue, pType, pName));
            }
            beanDefinition.setConstructorArgumentValues(avs);

            this.simpleBeanFactory.registerBeanDefinition(beanID, beanDefinition);
        }
    }
}