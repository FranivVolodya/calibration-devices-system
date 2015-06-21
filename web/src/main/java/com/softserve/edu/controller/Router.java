package com.softserve.edu.controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * Routing between pages
 */
@Controller
public class Router {

    /**
     * Displays welcome page
     *
     * @return welcome page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "/resources/app/welcome/index.html";
    }

    /**
     * Displays admin page
     *
     * @return admin page
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "/resources/app/admin/index.html";
    }

    /**
     * Displays provider page
     *
     * @return provider page
     */
    @RequestMapping(value = "/provider", method = RequestMethod.GET)
    public String provider() {
        return "/resources/app/provider/index.jsp";
    }
    
    /**
     * Displays provider Employee page
     *
     * @return provider page
     */
    @RequestMapping(value = "/provideremployee", method = RequestMethod.GET)
    public String providerEmploee() {
        return "/resources/app/provider/index.jsp";
    }
    

    
    
    /**
     * Displays calibrator page
     *
     * @return calibrator page
     */
    @RequestMapping(value = "/calibrator", method = RequestMethod.GET)
    public String calibrator() {
        return "/resources/app/calibrator/index.html";
    }

    /**
     * Displays verificator page
     *
     * @return verificator page
     */
    @RequestMapping(value = "/verificator", method = RequestMethod.GET)
    public String verificator() {
        return "/resources/app/verificator/index.html";
    }

}
