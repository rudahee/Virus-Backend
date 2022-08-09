package com.virus.model.dtos;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.virus.model.enumerateds.UserRole;

@JsonInclude(Include.NON_NULL)
public class AppUserDTO {

	private Long id;
	
	private String username;
	private String password;
	private String email;
	
	private String birthDate;
		
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
		
	private LocalDateTime lastPasswordChange;
	private LocalDateTime nextPasswordChange;
	
	private Boolean enableAccount;
	
	private HashSet<UserRole> roles;

	private String activationCode;
	private String imageProfile;

	public AppUserDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public LocalDateTime getNextPasswordChange() {
		return nextPasswordChange;
	}

	public void setNextPasswordChange(LocalDateTime nextPasswordChange) {
		this.nextPasswordChange = nextPasswordChange;
	}

	public HashSet<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<UserRole> roles) {
		this.roles = roles;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Boolean getEnableAccount() {
		return enableAccount;
	}

	public void setEnableAccount(Boolean enableAccount) {
		this.enableAccount = enableAccount;
	}

	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
