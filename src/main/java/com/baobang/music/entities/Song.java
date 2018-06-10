package com.baobang.music.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String listens;

	@Lob
	private String lyrics;

	private String name;

	private String singer;

	@Lob
	private String url;

	private String writter;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListens() {
		return this.listens;
	}

	public void setListens(String listens) {
		this.listens = listens;
	}

	public String getLyrics() {
		return this.lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return this.singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWritter() {
		return this.writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}

}