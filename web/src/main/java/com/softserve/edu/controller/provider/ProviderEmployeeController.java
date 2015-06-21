package com.softserve.edu.controller.provider;

import java.util.HashMap;
import java.util.Map;

import com.softserve.edu.entity.Organization;
import com.softserve.edu.entity.user.ProviderEmployee;
import com.softserve.edu.service.SecurityUserDetailsService;
import com.softserve.edu.service.UserService;
import com.softserve.edu.service.admin.OrganizationsService;
import com.softserve.edu.service.provider.ProviderEmployeeService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "provider/admin/users/")
public class ProviderEmployeeController {

    Logger logger = Logger.getLogger(ProviderEmployeeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationsService organizationsService;

    @Autowired
    private ProviderEmployeeService providerEmployeeService;
    
    @RequestMapping(value = "role", method = RequestMethod.GET)
    public Map<String, Object> rolDrsider() {
    	Map<String, Object> mod = new HashMap <String, Object>();
    	mod.put("admin","admin");
    	System.out.println(mod.toString());
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        return mod;
    }

    /**
     * Check whereas {@code username} is available,
     * i.e. it is possible to create new user with this {@code username}
     *
     * @param username username
     * @return {@literal true} if {@code username} available or else {@literal false}
     */
    @RequestMapping(value = "available/{username}", method = RequestMethod.GET)
    public Boolean isValidUsername(@PathVariable String username) {
        boolean isAvailable = false;
        if (username != null) {
            isAvailable = userService.existsWithUsername(username);
        }
        return isAvailable;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addEmployee(
            @RequestBody ProviderEmployee providerEmployee,
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails user) {

        Organization employeeOrganization = organizationsService.findById(user.getOrganizationId());
        providerEmployee.setOrganization(employeeOrganization);

        providerEmployeeService.addEmployee(providerEmployee);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}
