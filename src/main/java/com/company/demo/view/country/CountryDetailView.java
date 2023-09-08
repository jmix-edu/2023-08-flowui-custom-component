package com.company.demo.view.country;

import com.company.demo.entity.Country;

import com.company.demo.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "countries/:id", layout = MainView.class)
@ViewController("Country.detail")
@ViewDescriptor("country-detail-view.xml")
@EditedEntityContainer("countryDc")
public class CountryDetailView extends StandardDetailView<Country> {
}