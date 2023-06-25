package com.ScrumTool.Permission;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.RolePermission.RolePermission;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Permission_Id")
    private long permissionId;

    @Column(name = "Permission_Name")
    private String permissionName;

    @JsonIgnore
    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RolePermission> rolePermission = new ArrayList<>();

	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(List<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public Permission(long permissionId, String permissionName, List<RolePermission> rolePermission) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.rolePermission = rolePermission;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}