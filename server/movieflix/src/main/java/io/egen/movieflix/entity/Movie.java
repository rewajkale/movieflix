package io.egen.movieflix.entity;


import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle ORDER BY m.year DESC") ,
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByGenre", query = "select m from Movie m inner join m.genre g where g.kind = :pGenre ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findAllSortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByYear", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByYearSortByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findBygenreortByYear", query = "select m from Movie m inner join m.genre g where g.kind = :pGenre ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findAllSortByRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByRating", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findByYearSortByRating", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findBygenreortByRating", query = "select m from Movie m inner join m.genre g where g.kind = :pGenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findAllSortByVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByVotes", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findByYearSortByVotes", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findBygenreortByVotes", query = "select m from Movie m inner join m.genre g where g.kind = :pGenre ORDER BY m.imdbVotes DESC")
})	

public class Movie {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@Column(unique= true)
	private String title;
	
	private int year;
	private String rated;
	private String released;
	private String runtime;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Genre> genre; 
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Cast> casts;
	
	private String plot;
		
	public Set<Genre> getGenre() {
		return genre;
	}
	public void setGenre(Set<Genre> genre) {
		this.genre = genre;
	}
	
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metascore;
	private double imdbRating;
	private int imdbVotes;
	private String imdbID;
	private String type;
	
	
	
	public Set<Cast> getCasts() {
		return casts;
	}
	
	public void setCasts(Set<Cast> casts) {
		this.casts = casts;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
