package com.company.demo.view.city;

import com.company.demo.entity.City;

import com.company.demo.view.main.MainView;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "cities", layout = MainView.class)
@ViewController("City.list")
@ViewDescriptor("city-list-view.xml")
@LookupComponent("citiesDataGrid")
@DialogMode(width = "64em")
public class CityListView extends StandardListView<City> {

    @ViewComponent
    private DataGrid<City> citiesDataGrid;

    @Autowired
    private DialogWindows dialogWindows;
    @Autowired
    private ViewNavigators viewNavigators;

    @Subscribe("openCityEditorBtn")
    public void onOpenCityEditorBtnClick(final ClickEvent<JmixButton> event) {
        /*DialogWindow<CityDetailView> dialogWindow = dialogWindows.detail(citiesDataGrid)
                .withViewClass(CityDetailView.class)
                .build();

        CityDetailView cityDetailView = dialogWindow.getView();

        Component nameField = cityDetailView.getContent().getComponent("nameField");

        dialogWindow.open();*/

        viewNavigators.detailView(citiesDataGrid)
                .withViewClass(CityDetailView.class)
                .withAfterNavigationHandler(navigationEvent -> {
                    CityDetailView cityDetailView = navigationEvent.getView();
                    Component nameField = cityDetailView.getContent().getComponent("nameField");
                    System.out.println();
                }).navigate();
    }
}