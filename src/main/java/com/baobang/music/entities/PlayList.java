package com.baobang.music.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the play_list database table.
 * 
 */
@Entity
@Table(name="play_list")
@NamedQuery(name="PlayList.findAll", query="SELECT p FROM PlayList p")
public class PlayList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public PlayList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}