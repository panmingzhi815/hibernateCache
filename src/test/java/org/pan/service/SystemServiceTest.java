package org.pan.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pan.domain.SystemUser;

/**
 * Created by panmingzhi815 on 2014/8/11.
 */
public class SystemServiceTest extends AbstractServiceTest{
    @Test
    public void findTest() throws InterruptedException {
        SystemService systemService = getSystemService();

        SystemUser systemUser = new SystemUser();
        systemUser.setUserName("pan");
        final Long aLong = systemService.saveSystemUser(systemUser);

        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemService systemService = getSystemService();
                    systemService.findSystemUserById(aLong);
                }
            });
            thread.start();
            thread.join();
        }
    }

}
