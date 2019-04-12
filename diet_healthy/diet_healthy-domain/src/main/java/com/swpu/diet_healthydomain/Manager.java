package com.swpu.diet_healthydomain;


import java.sql.Date;

public class Manager {
	private Integer id;
	private String name;
	private String password;
	private Integer actor;
	private String creation;
	private String modified;
	public Manager() {}
	public Manager(String name, String password, Integer actor) {
		super();
		this.name = name;
		this.password = password;
		this.actor = actor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActor() {
		return actor;
	}

	public void setActor(Integer actor) {
		this.actor = actor;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", actor=" + actor +
				", creation=" + creation +
				", modified=" + modified +
				'}';
	}
}
