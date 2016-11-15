package im.chaitanya.StarWarsShips.Network.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The Recyclerview displays a list of RecyclerShips.
 *
 * A RecyclerShip is a stripped down Ship object which implements the Parcelable interface so that
 * when MainActivity is restored the list of RecyclerShips isn't lost.
 */
public class RecyclerShip implements Parcelable{
    private String shipName;
    private Long cost;
    private String costInString;
    private String films;

    public RecyclerShip(String shipName, Long cost, String costInString, String films) {
        this.shipName = shipName;
        this.cost = cost;
        this.costInString = costInString;
        this.films = films;
    }

    private RecyclerShip(Parcel in) {
        this.shipName = in.readString();
        this.cost = in.readLong();
        this.costInString = in.readString();
        this.films = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(shipName);
        out.writeLong(cost);
        out.writeString(costInString);
        out.writeString(films);
    }

    public static final Parcelable.Creator<RecyclerShip> CREATOR = new Parcelable.Creator<RecyclerShip>() {
        public RecyclerShip createFromParcel(Parcel in) {
            return new RecyclerShip(in);
        }

        public RecyclerShip[] newArray(int size) {
            return new RecyclerShip[size];
        }
    };

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getCostInString() {
        return costInString;
    }

    public void setCostInString(String costInString) {
        this.costInString = costInString;
    }

    @Override
    public String toString() {
        return "RecyclerShip{" +
                "cost=" + cost +
                ", shipName='" + shipName + '\'' +

                ", films='" + films + '\'' +
                '}' + '\n';
    }
}
