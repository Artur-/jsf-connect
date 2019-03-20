package com.codenotfound.primefaces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{param.pageId}")
    private String pageId;

    public String showPage() {
        System.err.println("page: " + pageId);
        if ("dashboard".equals(pageId)) {
            return "dashboard";
        } else if ("user-admin".equals(pageId)) {
            // TODO role
            return "user-admin";
        } else {
            return "home";
        }
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}