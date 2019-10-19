package com.nit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usertab")
public class User {
	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	@Column(name="uname")
	private String userName;
	@Column(name="upwd")
	private String userPassword;
	@Column(name="ugen")
	private String userGen;
	@Column(name="urole")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> userRoles;
	@Column(name="city")
	private String userCity;
	
	


}
