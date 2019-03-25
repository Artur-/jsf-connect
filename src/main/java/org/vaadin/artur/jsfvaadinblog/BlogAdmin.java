package org.vaadin.artur.jsfvaadinblog;

import java.util.List;

import javax.annotation.ManagedBean;

import org.vaadin.artur.jsfvaadinblog.data.BlogPost;

@ManagedBean
public class BlogAdmin {

    public List<BlogPost> getBlogPosts() {
        return BlogPostService.getBlogPosts();
    }

    public String abbreviate(String content) {
        int limit = 20;
        if (content.length() <= limit) {
            return content;
        } else {
            return content.substring(0, limit) + "...";
        }
    }

    public String delete(BlogPost post) {
        BlogPostService.removePost(post.getId());

        return "blog-admin?faces-redirect=true";
    }
}