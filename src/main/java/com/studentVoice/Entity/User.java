package com.studentVoice.Entity;

//import java.util.Arrays;
//import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name="Admin")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	@Lob
//	@Column(name="profile_photo",length=200000)
//	private byte[] photo;
	
	private String name;
	private String email;
	private String contact;
	private String password;
	private String location;
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "users_roles",
//			joinColumns = @JoinColumn(
//		            name = "user_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(
//				            name = "role_id", referencedColumnName = "id"))
//	
//	private Collection<Role> roles;
	
	public User(/*byte[] photo,*/ String name, String email, String contact, String password, String location/*,Collection<Role> roles*/) {
		super();
		//this.photo = photo;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.location = location;
		//this.roles=roles;
	}
	
	public User() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
//	public byte[] getPhoto() {
//		return photo;
//	}
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
//	public Collection<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(Collection<Role> roles) {
//		this.roles = roles;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + /*", photo=" + Arrays.toString(photo) + */", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", password=" + password + ", location=" + location + "]";
	}
	
}
