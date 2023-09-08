package com.company.demo.view.country;

import com.company.demo.entity.Country;

import com.company.demo.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "countries", layout = MainView.class)
@ViewController("Country.list")
@ViewDescriptor("country-list-view.xml")
@LookupComponent("countriesDataGrid")
@DialogMode(width = "64em")
public class CountryListView extends StandardListView<Country> {
}