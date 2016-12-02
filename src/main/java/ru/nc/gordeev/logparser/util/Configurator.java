package ru.nc.gordeev.logparser.util;

import java.util.Properties;

    /** ConfigurationManager uses Configurator implementations to configure application properties.
     *  To add a property, declare it within a .property file, make a Configurator implementation
     *  which configures this property and hand it over to ConfigMans constructor along side with
     *  the other implementations.
     */

public interface Configurator {
    void setConfiguration(Properties properties);
    void setInitialConfiguration();
}