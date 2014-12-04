package com.alm.pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Groups")
public class GroupPOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gid")
	private int gid;

	private String description;

	private String name;

	private String status;

	public GroupPOJO() {
	}

	public int getGid() {
		return this.gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public List<Userpojo> getUserpojos() { return this.userpojos; }
	 * 
	 * public void setUserpojos(List<Userpojo> userpojos) { this.userpojos =
	 * userpojos; }
	 */

	/*
	 * public Userpojo addUserpojo(Userpojo userpojo) {
	 * getUserpojos().add(userpojo); userpojo.setGrouppojo(this); return
	 * userpojo; }
	 * 
	 * public Userpojo removeUserpojo(Userpojo userpojo) {
	 * getUserpojos().remove(userpojo); userpojo.setGrouppojo(null); return
	 * userpojo; }
	 */
	@Override
	public String toString() {
		return "Grouppojo [gid=" + gid + ", description=" + description
				+ ", name=" + name + ", status=" + status + "]";
	}

}