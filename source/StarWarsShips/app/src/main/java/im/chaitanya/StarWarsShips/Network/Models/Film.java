package im.chaitanya.StarWarsShips.Network.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("episode_id")
    @Expose
    private Integer episodeId;

    @SerializedName("opening_crawl")
    @Expose
    private String openingCrawl;

    @SerializedName("director")
    @Expose
    private String director;

    @SerializedName("producer")
    @Expose
    private String producer;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("characters")
    @Expose
    private List<String> characters = new ArrayList<>();

    @SerializedName("planets")
    @Expose
    private List<String> planets = new ArrayList<>();

    @SerializedName("starships")
    @Expose
    private List<String> starships = new ArrayList<>();

    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = new ArrayList<>();

    @SerializedName("species")
    @Expose
    private List<String> species = new ArrayList<>();

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("edited")
    @Expose
    private String edited;

    @SerializedName("url")
    @Expose
    private String url;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The episodeId
     */
    public Integer getEpisodeId() {
        return episodeId;
    }

    /**
     *
     * @param episodeId
     * The episode_id
     */
    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    /**
     *
     * @return
     * The openingCrawl
     */
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    /**
     *
     * @param openingCrawl
     * The opening_crawl
     */
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    /**
     *
     * @return
     * The director
     */
    public String getDirector() {
        return director;
    }

    /**
     *
     * @param director
     * The director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     *
     * @return
     * The producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     *
     * @param producer
     * The producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     *
     * @return
     * The characters
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     * The characters
     */
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    /**
     *
     * @return
     * The planets
     */
    public List<String> getPlanets() {
        return planets;
    }

    /**
     *
     * @param planets
     * The planets
     */
    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    /**
     *
     * @return
     * The starships
     */
    public List<String> getStarships() {
        return starships;
    }

    /**
     *
     * @param starships
     * The starships
     */
    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    /**
     *
     * @return
     * The vehicles
     */
    public List<String> getVehicles() {
        return vehicles;
    }

    /**
     *
     * @param vehicles
     * The vehicles
     */
    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @return
     * The species
     */
    public List<String> getSpecies() {
        return species;
    }

    /**
     *
     * @param species
     * The species
     */
    public void setSpecies(List<String> species) {
        this.species = species;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The edited
     */
    public String getEdited() {
        return edited;
    }

    /**
     *
     * @param edited
     * The edited
     */
    public void setEdited(String edited) {
        this.edited = edited;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}