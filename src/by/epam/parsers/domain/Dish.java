package by.epam.parsers.domain;

/**
 * Created by Владислав on 21.05.2016.
 */
public class Dish {
    private String photo;
    private String name;
    private String description;
    private String portion;
    private int price;

    public Dish() {
    }

    public Dish(String photo, String name, String description, String portion, int price) {
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.portion = portion;
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (price != dish.price) return false;
        if (photo != null ? !photo.equals(dish.photo) : dish.photo != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (description != null ? !description.equals(dish.description) : dish.description != null) return false;
        return !(portion != null ? !portion.equals(dish.portion) : dish.portion != null);

    }

    @Override
    public int hashCode() {
        int result = photo != null ? photo.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (portion != null ? portion.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", portion='" + portion + '\'' +
                ", price=" + price +
                '}';
    }
}
