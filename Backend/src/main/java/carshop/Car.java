package carshop;

import jakarta.persistence.*;

@Entity
@Table(name = "cars") // Entspricht der PostgreSQL-Tabelle
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String image;
    private String shortDescription;
    private String fullDescription;

    public Car() {}

    public Car(String brand, String model, String image, String shortDescription, String fullDescription) {
        this.brand = brand;
        this.model = model;
        this.image = image;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
