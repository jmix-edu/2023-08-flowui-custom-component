package com.company.demo.view.city;

import com.company.demo.entity.City;

import com.company.demo.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "cities/:id", layout = MainView.class)
@ViewController("City.detail")
@ViewDescriptor("city-detail-view.xml")
@EditedEntityContainer("cityDc")
public class CityDetailView extends StandardDetailView<City> {
}