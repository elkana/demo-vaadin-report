package com.example.demovaadinreport.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class ReportView extends VerticalLayout{
    public ReportView() {
        // var report = new PrintPreviewReport<>(Employee.class, "id", "name", "address");

        add(new H1("Hello Jasper"), new Button("generate", click -> {
            //
        }));
    }
}
