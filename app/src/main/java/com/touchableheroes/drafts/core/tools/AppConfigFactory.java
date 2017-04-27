package com.touchableheroes.drafts.core.tools;

/**
 * Created by asiebert on 15.04.2017.
 */

public class AppConfigFactory {

    public AppConfig config() {
        return new AppConfig();
    }

    public <T> T specific( Class<T> type ) {
        return null;
    }



}
