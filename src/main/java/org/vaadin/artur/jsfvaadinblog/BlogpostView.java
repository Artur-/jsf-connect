package org.vaadin.artur.jsfvaadinblog;

import java.time.LocalDateTime;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.vaadin.artur.jsfvaadinblog.data.BlogPost;

@ManagedBean
@ViewScoped
public class BlogpostView {

    @PostConstruct
    public void init() {
        String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            this.item = BlogPostService.getBlogPost(id).orElse(new BlogPost());
        }
    }

    private BlogPost item = new BlogPost();

    public BlogPost getItem() {
        return item;
    }

    public String save() {
        if (item.getId() != null) {
            BlogPostService.updatePost(item);
            return "blog-admin?faces-redirect=true";
        } else {
            item.setPublishTime(LocalDateTime.now());
            item.setAuthor(SecurityContextHolder.getContext().getAuthentication().getName());
            BlogPostService.addPost(item);
            return "index?faces-redirect=true";
        }
    }

}