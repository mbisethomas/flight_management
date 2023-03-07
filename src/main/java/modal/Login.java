package modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")

public class Login {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int aid;
private String name;
private String email;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Login [aid=" + aid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
}



}
