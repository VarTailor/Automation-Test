package com.bdd.hooks;

import com.bdd.actionPages.BaseClass;
import cucumber.api.java.After;

public class Hooks extends BaseClass {

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
