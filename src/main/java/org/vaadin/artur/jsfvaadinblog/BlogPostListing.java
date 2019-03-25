package org.vaadin.artur.jsfvaadinblog;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import org.vaadin.artur.jsfvaadinblog.data.BlogPost;

@ManagedBean
@RequestScoped
public class BlogPostListing {

    public List<BlogPost> getBlogPosts() {
        return BlogPostService.getBlogPosts();
    }

}