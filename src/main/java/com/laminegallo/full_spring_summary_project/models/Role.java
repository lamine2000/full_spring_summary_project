package com.laminegallo.full_spring_summary_project.models;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    private String autority;

    public Role(String autority) {
        this.autority = autority;
    }

    public Role() {}

    @Override
    public String getAuthority() {
        return null;
    }
}
