package org.aioba.test;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "org.aioba")
@Scope("prototype")
public class SpringTest {

    public static void main(String[] args){
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringTest.class);
        SpringTest st = app.getBean(SpringTest.class);
        st.go();
    }

    @Autowired
    private BusinessService service;

    @Autowired
    private HikariDataSource ds;

    public void go(){

        Business larry   = new Business("larry.faria",   55, 100.0);
        Business paula   = new Business("paula.faria",   50, 200.0);
        Business jarrier = new Business("jarrier.faria", 37, 300.0);
        Business giscard = new Business("giscard.faria", 34, 400.0);
        Business thierry = new Business("thierry.faria", 28, 500.0);

        service.createBusiness(larry);
        service.createBusiness(paula);
        service.createBusiness(jarrier);
        service.createBusiness(giscard);
        service.createBusiness(thierry);

        giscard.setSalary(1000.0);
        service.updateBusiness(giscard);
        service.deleteBusiness(thierry);

        System.out.println(service.listBusiness());

        for(int i = 0; i < 100; i++) {
            try {
                System.out.println(service.listAllBusiness());
            }catch(Exception ex){;}
            System.out.println("Active  : " + ds.getHikariPoolMXBean().getActiveConnections());
            System.out.println("Idle    : " + ds.getHikariPoolMXBean().getIdleConnections());
            System.out.println("Awaiting: " + ds.getHikariPoolMXBean().getThreadsAwaitingConnection());
            System.out.println("Total   : " + ds.getHikariPoolMXBean().getTotalConnections());

        }

    }


}
