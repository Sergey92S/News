package com.revotech.news.entities;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Revotech on 14.06.2016.
 */
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    private String author;
    private String date;
    private String title;
    private String content;
    private String image;
    private int id;

    public News(){

    }

    public News(String author, String date, String title, String content, String image, int id){
        this.author=author;
        this.date=date;
        this.title=title;
        this.content=content;
        this.image=image;
        this.id=id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (author != null ? !author.equals(news.author) : news.author != null) return false;
        if (date != null ? !date.equals(news.date) : news.date != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        return image != null ? image.equals(news.image) : news.image == null;

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                '}';
    }
}
