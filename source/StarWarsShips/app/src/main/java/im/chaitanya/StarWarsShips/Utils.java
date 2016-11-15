package im.chaitanya.StarWarsShips;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import im.chaitanya.StarWarsShips.Network.Models.RecyclerShip;
import im.chaitanya.StarWarsShips.Network.Models.Ship;

class Utils {

    /**
     * populates an Arraylist of {@link RecyclerShip} from Arraylist of {@link Ship}
     * @param allShips
     *      list of Ships from the API
     * @param allFilmURLsMap
     *      Hashmap of film URL to film name
     * @param allRecyclerShips
     *      arraylist which will be filled and returned
     * @return
     *      returns the populated arraylist
     */
    static ArrayList<RecyclerShip> populateRecyclerShipList(List<Ship> allShips, Map<String, String> allFilmURLsMap, ArrayList<RecyclerShip> allRecyclerShips) {
        Pattern pattern = Pattern.compile("\\d+");
        for (Ship ship: allShips) {
            String shipName = ship.getName();
            String costInString = "Cost: " + ship.getCostInCredits();
            String concatenatedFilmNames = concatenateFilmNames(ship.getFilms(), allFilmURLsMap);
            Long cost;

            if (pattern.matcher(ship.getCostInCredits()).matches())
                cost = Long.parseLong(ship.getCostInCredits());
            else
                cost = 0L;

            if(concatenatedFilmNames.contains(","))
                concatenatedFilmNames = "Films: " + concatenatedFilmNames;
            else
                concatenatedFilmNames = "Film: " + concatenatedFilmNames;

            RecyclerShip tempShip = new RecyclerShip(shipName, cost, costInString, concatenatedFilmNames);
            allRecyclerShips.add(tempShip);
        }
        return allRecyclerShips;
    }

    /**
     * Sorts RecyclerShip arraylist by cost in descending order using Comparator.
     * @param allRecyclerShips
     *      arraylist of RecyclerShips
     * @return
     *      sorted arraylist of RecyclerShips
     */
    static ArrayList<RecyclerShip> sortRecyclerShips(ArrayList<RecyclerShip> allRecyclerShips) {
        Collections.sort(allRecyclerShips, new Comparator<RecyclerShip>() {
            @Override
            public int compare(RecyclerShip ship1, RecyclerShip ship2) {
                Long diff = ship1.getCost() - ship2.getCost();
                if(diff < 0)
                    return 1;
                else if (diff > 0)
                    return -1;
                else
                    return 0;
            }
        });
        return allRecyclerShips;
    }

    /**
     * Concatenates film names into a comma separated string.
     * @param filmURLs
     *      URL of the film from json
     * @param allFilmURLsMap
     *      Map of URL to film name
     * @return
     *      comma separated String of film names is returned
     */
    static private String concatenateFilmNames(List<String> filmURLs, Map<String, String> allFilmURLsMap) {
        List<String> filmNames = new ArrayList<>();
        for (String filmURL: filmURLs) {
            filmNames.add(allFilmURLsMap.get(filmURL));
        }
        return TextUtils.join(", ", filmNames);
    }
}
