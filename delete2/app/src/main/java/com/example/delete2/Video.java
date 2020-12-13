package com.example.delete2;

import java.io.Serializable;

public class Video implements Serializable {

    private Integer number;
    private String nameModul;
    private String nameVideo;

    public Video(Integer number, String nameModul, String nameVideo) {
        this.number = number;
        this.nameModul = nameModul;
        this.nameVideo = nameVideo;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNameModul() {
        return nameModul;
    }

    public String getNameVideo() {
        return nameVideo;
    }
}
