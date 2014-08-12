package org.pan.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.pan.domain.SystemRole;

/**
 * Created by panmingzhi815 on 2014/8/12.
 */
public class AbstractServiceTest {

    private static Injector injector;

    @BeforeClass
    public static void init(){
        injector = Guice.createInjector(new JpaPersistModule("derby"));
        PersistService instance = injector.getInstance(PersistService.class);
        instance.start();
    }

    @AfterClass
    public static void destory(){
        PersistService instance = injector.getInstance(PersistService.class);
        instance.stop();
    }

    public SystemService getSystemService(){
        return injector.getInstance(SystemService.class);
    }
}
