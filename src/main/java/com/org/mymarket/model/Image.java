package com.org.mymarket.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by denis on 25.08.16.
 */
@Entity
@Table(name = "images")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageId")
    private Long imageId;
    @Column(name = "imageName")
    private String imageName;
    @Column(name = "imagePath")
    private String imagePath;

    public Image() {
    }

    public Image(String imagePath, String imageName) {

        this.imagePath = imagePath;
        this.imageName = imageName;
    }

    public String getImagePath() {

        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
