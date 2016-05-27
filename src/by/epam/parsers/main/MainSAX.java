package by.epam.parsers.main;

import by.epam.parsers.MenuTagNames;
import by.epam.parsers.domain.Dish;
import by.epam.parsers.domain.Kind;
import by.epam.parsers.domain.Menu;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Владислав on 24.05.2016.
 */
public class MainSAX implements MenuTagNames {

    private static final String xmlFileURI = "resources/menu.xml";

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MenuHandler menuHandler = new MenuHandler();
        xmlReader.setContentHandler(menuHandler);
        xmlReader.parse(new InputSource(new FileInputStream(new File(xmlFileURI))));

        Menu menu = menuHandler.getMenu();

        System.out.println("Меню:\n");
        for(Kind kind : menu.getKinds()) {
            System.out.println(kind.getName());
            for(Dish dish : kind.getDishes()) {
                System.out.println("Фото: " + dish.getPhoto() + " Название: " + dish.getName() + " Описание: " + dish.getDescription() + " Порция: " + dish.getPortion() + " Цена: " + dish.getPrice());
            }
        }
    }

    private static class MenuHandler extends DefaultHandler {
        private Menu menu;
        private Kind currentKind;
        private Dish currentDish;
        private StringBuilder text;

        public Menu getMenu() {
            return menu;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (localName) {
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
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (localName) {
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
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            text = new StringBuilder(length);
            text.append(ch, start, length);
        }
    }
}
