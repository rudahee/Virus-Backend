package com.virus.model.database.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.virus.model.enumerateds.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class AppUser implements UserDetails{

	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -6310418546532088686L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable=false)
	private Boolean enableAccount;
	
	@CreatedDate
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	@Column(nullable = true)
	private LocalDateTime deleteTime;
	
	@Column(nullable = true)
	private String reasonForLockedAccount;

	@Column(nullable = true)
	private String reasonForExpiredAccount;
	
	private LocalDateTime lastPasswordChange;
	
	private LocalDateTime nextPasswordChange;
	
	private HashSet<UserRole> roles;

	@OneToOne(mappedBy = "user")
	private PlayerEntity player;
	
	public AppUser() {
		super();
		this.setEnableAccount(false);
		this.roles = new HashSet<UserRole>();
		this.createTime = LocalDateTime.now();
		this.updateTime = LocalDateTime.now();
	}
	
	public AppUser(String username, String encode, Collection<? extends GrantedAuthority> authorities) {
		this.setEnableAccount(false);
		this.roles = new HashSet<UserRole>();
		this.createTime = LocalDateTime.now();
		this.updateTime = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getEnableAccount() {
		return enableAccount;
	}

	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		// return roles with format: ROLE_NAME
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		Boolean expired = true;
		if (deleteTime != null) {
			expired = this.deleteTime.isAfter(LocalDateTime.now());			
		}
		this.reasonForExpiredAccount = "Account Deleted";
		
		return expired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enableAccount;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		boolean expired = false;
		if (deleteTime != null) {
			expired = true;
			this.reasonForExpiredAccount = "Account Deleted";

		} else {
			expired = this.lastPasswordChange.isBefore(this.nextPasswordChange);			
			if (expired) {
				this.reasonForExpiredAccount = "Password Expired. Please, recover your password.";				
			}

		}
		return expired;
	}

	@Override
	public boolean isEnabled() {
		if (!this.enableAccount) {
			this.reasonForLockedAccount = "Account not active. Please check your email.";			
		}
		
		return this.enableAccount;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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

	public String getReasonForLockedAccount() {
		return reasonForLockedAccount;
	}

	public void setReasonForLockedAccount(String reasonForLockedAccount) {
		this.reasonForLockedAccount = reasonForLockedAccount;
	}

	public String getReasonForExpiredAccount() {
		return reasonForExpiredAccount;
	}

	public void setReasonForExpiredAccount(String reasonForExpiredAccount) {
		this.reasonForExpiredAccount = reasonForExpiredAccount;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange() {
		this.lastPasswordChange = LocalDateTime.now();
	}

	public LocalDateTime getNextPasswordChange() {
		return nextPasswordChange;
	}

	public void setNextPasswordChange() {
		this.nextPasswordChange = LocalDateTime.now().plusMonths(3L);
	}

	public HashSet<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<UserRole> set) {
		this.roles = set;
	}

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.setLastPasswordChange();
		this.setNextPasswordChange();
		this.password = password;
	}

	public void setEnableAccount(Boolean enableAccount) {
		this.enableAccount = enableAccount;
	}

}
