package model;

public class Character {
    private String name;
    private String description;
    private int imageResId;

    // Constructor
    public Character(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
