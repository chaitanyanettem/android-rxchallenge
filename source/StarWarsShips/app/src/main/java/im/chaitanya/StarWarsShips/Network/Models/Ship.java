package im.chaitanya.StarWarsShips.Network.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ship {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;

    @SerializedName("cost_in_credits")
    @Expose
    private String costInCredits;

    @SerializedName("length")
    @Expose
    private String length;

    @SerializedName("max_atmosphering_speed")
    @Expose
    private String maxAtmospheringSpeed;

    @SerializedName("crew")
    @Expose
    private String crew;

    @SerializedName("passengers")
    @Expose
    private String passengers;

    @SerializedName("cargo_capacity")
    @Expose
    private String cargoCapacity;

    @SerializedName("consumables")
    @Expose
    private String consumables;

    @SerializedName("hyperdrive_rating")
    @Expose
    private String hyperdriveRating;

    @SerializedName("MGLT")
    @Expose
    private String mGLT;

    @SerializedName("starship_class")
    @Expose
    private String starshipClass;

    @SerializedName("pilots")
    @Expose
    private List<Object> pilots = new ArrayList<>();

    @SerializedName("films")
    @Expose
    private List<String> films = new ArrayList<>();

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("edited")
    @Expose
    private String edited;

    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getmGLT() {
        return mGLT;
    }

    public void setmGLT(String mGLT) {
        this.mGLT = mGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public List<Object> getPilots() {
        return pilots;
    }

    public void setPilots(List<Object> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
