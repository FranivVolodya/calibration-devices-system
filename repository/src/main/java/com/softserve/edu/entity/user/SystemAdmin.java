package com.softserve.edu.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SYS_ADMIN")
public class SystemAdmin extends User {

    enum AdminRole implements Role {
        SYS_ADMIN;

        @Override
        public String roleName() {
            return name();
        }
    }

    public SystemAdmin(String username, String password) {
        super(username, password, AdminRole.SYS_ADMIN);
    }

    public SystemAdmin() {
    }
}
