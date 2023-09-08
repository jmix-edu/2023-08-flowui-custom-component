package com.company.demo.component;

import com.company.demo.entity.City;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import io.jmix.core.MessageTools;
import io.jmix.core.common.util.Preconditions;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.data.value.ContainerValueSource;
import io.jmix.flowui.model.InstanceContainer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CityFragment extends Composite<FormLayout> implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private InstanceContainer<City> container;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public InstanceContainer<City> getContainer() {
        return container;
    }

    public void setContainer(InstanceContainer<City> container) {
        Preconditions.checkNotNullArgument(container);

        this.container = container;
        initField(container);
    }

    @SuppressWarnings("unchecked")
    private void initField(InstanceContainer<City> container) {
        UiComponents uiComponents = applicationContext.getBean(UiComponents.class);
        TypedTextField<String> nameField = uiComponents.create(TypedTextField.class);

        MessageTools messageTools = applicationContext.getBean(MessageTools.class);
        String propertyCaption = messageTools.getPropertyCaption(container.getEntityMetaClass(), "name");
        nameField.setLabel(propertyCaption);

        nameField.setValueSource(new ContainerValueSource<>(container, "name"));

        getContent().add(nameField);
    }
}
