package com.solvd.utilities.context;

import lombok.Getter;

@Getter
public enum View {

    NATIVE("NATIVE_APP"),
    CHROME("CHROMIUM"),
    SAFARI("WEBVIEW_safari");

    final String viewName;

    View(String viewName) {
        this.viewName = viewName;
    }

}
