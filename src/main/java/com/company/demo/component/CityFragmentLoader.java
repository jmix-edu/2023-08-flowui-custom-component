package com.company.demo.component;

import com.company.demo.entity.City;
import io.jmix.flowui.exception.GuiDevelopmentException;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;

public class CityFragmentLoader extends AbstractComponentLoader<CityFragment> {

    @Override
    protected CityFragment createComponent() {
        return factory.create(CityFragment.class);
    }

    @Override
    public void loadComponent() {
        String dataContainerId = loadString(element, "dataContainer")
                .orElseThrow(() ->
                        new GuiDevelopmentException("[CityFragment] 'dataContainer' is required", context));

        InstanceContainer<?> container = getComponentContext().getViewData().getContainer(dataContainerId);
        Class<Object> javaClass = container.getEntityMetaClass().getJavaClass();
        if (!City.class.isAssignableFrom(javaClass)) {
            throw new GuiDevelopmentException("Container must be associated with " +
                    City.class.getSimpleName(), context);
        }

        //noinspection UnnecessaryParentheses
        resultComponent.setContainer(((InstanceContainer<City>) container));
    }
}
