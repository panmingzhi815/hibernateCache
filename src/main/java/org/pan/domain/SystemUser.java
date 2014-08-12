package org.pan.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by panmingzhi815 on 2014/8/11.
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class SystemUser extends DomainObject {
    private String userName;
    @ManyToMany(mappedBy = "systemUserSet")
    private Set<SystemRole> systemRoleSet;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<SystemRole> getSystemRoleSet() {
        return systemRoleSet;
    }

    public void setSystemRoleSet(Set<SystemRole> systemRoleSet) {
        this.systemRoleSet = systemRoleSet;
    }
}
