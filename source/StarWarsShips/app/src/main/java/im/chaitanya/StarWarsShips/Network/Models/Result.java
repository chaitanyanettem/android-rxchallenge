package im.chaitanya.StarWarsShips.Network.Models;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("next")
    @Expose
    @Nullable
    private String next;

    @SerializedName("previous")
    @Expose
    @Nullable
    private String previous;

    @SerializedName("results")
    @Expose
    private List<Ship> ships = new ArrayList<>();

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * Get next page's address
     */
    @Nullable
    public String getNext() {
        return next;
    }

    /**
     *
     * @param next
     * Set next page address
     */
    public void setNext(@Nullable String next) {
        this.next = next;
    }

    /**
     *
     * @return
     * Get previous page's address
     */
    @Nullable
    public String getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     * Set previous page's address
     */
    public void setPrevious(@Nullable String previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     * Get ship list
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     *
     * @param ships
     * Set ship list
     */
    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
