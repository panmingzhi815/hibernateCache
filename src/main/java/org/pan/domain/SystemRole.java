package org.pan.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by panmingzhi815 on 2014/8/11.
 */
@Entity
public class SystemRole extends DomainObject {
    private String roleName;
    @ManyToMany
    private Set<SystemUser> systemUserSet;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<SystemUser> getSystemUserSet() {
        return systemUserSet;
    }

    public void setSystemUserSet(Set<SystemUser> systemUserSet) {
        this.systemUserSet = systemUserSet;
    }
}
