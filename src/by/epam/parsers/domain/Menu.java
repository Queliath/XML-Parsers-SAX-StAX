package by.epam.parsers.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 21.05.2016.
 */
public class Menu {
    private List<Kind> kinds;

    public Menu() {
        kinds = new ArrayList<>();
    }

    public Menu(List<Kind> kinds) {
        this.kinds = kinds;
    }

    public List<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(List<Kind> kinds) {
        this.kinds = kinds;
    }

    public void addKind(Kind kind) {
        this.kinds.add(kind);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return !(kinds != null ? !kinds.equals(menu.kinds) : menu.kinds != null);

    }

    @Override
    public int hashCode() {
        return kinds != null ? kinds.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "kinds=" + kinds +
                '}';
    }
}
