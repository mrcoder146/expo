package com.ScrumTool.RolePermission;

import com.ScrumTool.Permission.Permission;
import com.ScrumTool.Role.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Role_Permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Permission_Id")
    private long rolePermissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_Id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Permission_Id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Permission permission;

	public long getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(long rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public RolePermission(long rolePermissionId, Role roleId, Permission permission) {
		super();
		this.rolePermissionId = rolePermissionId;
		this.roleId = roleId;
		this.permission = permission;
	}

	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}