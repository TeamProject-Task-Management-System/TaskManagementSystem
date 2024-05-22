package com.company.oop.teamProject.utils;

import com.company.oop.teamProject.models.contracts.Printable;

import java.util.ArrayList;
import java.util.List;

public class ListingHelper {

    public static final String JOIN_DELIMITER = "####################";

    public static <T extends Printable> String elementsToString(List<T> elements) {
        List<String> result = new ArrayList<>();
        for (T element : elements) {
            result.add(element.getAsString());
        }

        return String.join(JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }
}
