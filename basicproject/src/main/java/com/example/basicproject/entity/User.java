package com.example.basicproject.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	    @Id
	      @Column(name="user_name")
          private String userName;
	      @Column(name="pass_Word")
          private String password;

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public int hashCode() {
			return Objects.hash(password, userName);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
		}
		@Override
		public String toString() {
			return "User [userName=" + userName + ", password=" + password + "]";
		}
	      
	      
}
