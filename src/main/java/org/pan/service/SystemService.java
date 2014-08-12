package org.pan.service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import org.pan.domain.SystemRole;
import org.pan.domain.SystemUser;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * Created by panmingzhi815 on 2014/8/11.
 */
@Singleton
public class SystemService{

    @Inject
    protected Provider<EntityManager> em;

    @Transactional
    public Long saveSystemUser(SystemUser systemUser){
        if(systemUser.getId() == null){
            em.get().persist(systemUser);
        }else{
            em.get().merge(systemUser);
        }
        return systemUser.getId();
    }

    @Transactional
    public Long saveSystemRole(SystemRole systemRole){
        if(systemRole.getId() == null){
            em.get().persist(systemRole);
        }else{
            em.get() .merge(systemRole);
        }
        return systemRole.getId();
    }

    public SystemUser findSystemUserById(Long id){
        return em.get().find(SystemUser.class,id);
    }

    public SystemRole findSystemRoleById(Long id){
        return em.get().find(SystemRole.class,id);
    }

    public Set<SystemRole> findSystemRoleSetByUserId(Long id){
        SystemUser systemUser = em.get().find(SystemUser.class, id);
        return systemUser.getSystemRoleSet();
    }
}
