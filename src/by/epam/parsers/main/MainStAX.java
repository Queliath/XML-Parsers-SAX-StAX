package by.epam.parsers.main;

import by.epam.parsers.MenuTagNames;
import by.epam.parsers.domain.Dish;
import by.epam.parsers.domain.Kind;
import by.epam.parsers.domain.Menu;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Владислав on 24.05.2016.
 */
public class MainStAX implements MenuTagNames {

    private static final String xmlFileURI = "resources/menu.xml";

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(new File(xmlFileURI)));

        Menu menu = readMenu(xmlStreamReader);

        System.out.println("Меню:\n");
        for(Kind kind : menu.getKinds()) {
            System.out.println(kind.getName());
            for(Dish dish : kind.getDishes()) {
                System.out.println("Фото: " + dish.getPhoto() + " Название: " + dish.getName() + " Описание: " + dish.getDescription() + " Порция: " + dish.getPortion() + " Цена: " + dish.getPrice());
            }
        }
    }

    public static Menu readMenu(XMLStreamReader xmlStreamReader) throws XMLStreamException {
        Menu menu = null;
        Kind currentKind = null;
        Dish currentDish = null;
        StringBuilder text = null;

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {

                case XMLStreamConstants.START_ELEMENT:
                    switch (xmlStreamReader.getLocalName()) {
                        case menuTag:
                            menu = new Menu();
                            break;
                        case kindTag:
                            currentKind = new Kind();
                            break;
                        case dishTag:
                            currentDish = new Dish();
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (xmlStreamReader.getLocalName()) {
                        case kindTag:
                            menu.addKind(currentKind);
                            break;
                        case dishTag:
                            currentKind.addDish(currentDish);
                            break;
                        case kindNameTag:
                            currentKind.setName(text.toString());
                            break;
                        case dishPhotoTag:
                            currentDish.setPhoto(text.toString());
                            break;
                        case dishNameTag:
                            currentDish.setName(text.toString());
                            break;
                        case dishDescriptionTag:
                            currentDish.setDescription(text.toString());
                            break;
                        case dishPortionTag:
                            currentDish.setPortion(text.toString());
                            break;
                        case dishPriceTag:
                            currentDish.setPrice(Integer.parseInt(text.toString()));
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    text = new StringBuilder();
                    text.append(xmlStreamReader.getText());
                    break;

            }

        }

        return menu;
    }
}
