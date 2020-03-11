package com.prelim.jdbc.Storedb;

public class Competition {

    String title;
    String rem_time;
    String link;
    String source;

    public Competition(String title, String rem_time, String link, String source) {
        this.title = title;
        this.rem_time = rem_time;
        this.link = link;
        this.source = source;
    }
    public Competition() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRem_time() {
        return rem_time;
    }

    public void setRem_time(String rem_time) {
        this.rem_time = rem_time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "title='" + title + '\'' +
                ", rem_time='" + rem_time + '\'' +
                ", link='" + link + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
