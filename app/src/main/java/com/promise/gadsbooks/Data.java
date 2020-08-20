package com.promise.gadsbooks;

import androidx.annotation.NonNull;

public class Data {
    String title;
    String subtitle;
    String heading;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Data() {
    }

    public Data(String title, String subtitle, String heading) {
        this.title = title;
        this.subtitle = subtitle;
        this.heading = heading;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
