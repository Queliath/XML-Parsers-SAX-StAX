package by.epam.parsers.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 21.05.2016.
 */
public class Kind {
    private String name;
    private List<Dish> dishes;

    public Kind() {
        dishes = new ArrayList<>();
    }

    public Kind(String name) {
        this.name = name;
    }

    public Kind(String name, List<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kind kind = (Kind) o;

        if (name != null ? !name.equals(kind.name) : kind.name != null) return false;
        return !(dishes != null ? !dishes.equals(kind.dishes) : kind.dishes != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
