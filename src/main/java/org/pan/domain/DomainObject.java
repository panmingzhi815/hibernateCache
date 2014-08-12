package org.pan.domain;

import javax.persistence.*;

/**
 * Created by panmingzhi815 on 2014/8/11.
 */
@MappedSuperclass
public class DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
