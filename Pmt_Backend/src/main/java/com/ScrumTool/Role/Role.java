package com.ScrumTool.Role;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.ProjectUserRole.ProjectUserRole;
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
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Id")
    private long roleId;

    @Column(name = "Role_Name")
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RolePermission> rolePermission = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProjectUserRole> projectUserRole = new ArrayList<>();

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(List<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public Role(long roleId, String roleName, List<RolePermission> rolePermission) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolePermission = rolePermission;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	
}
