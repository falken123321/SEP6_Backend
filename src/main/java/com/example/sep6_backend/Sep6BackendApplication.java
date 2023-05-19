
package com.example.sep6_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Sep6BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sep6BackendApplication.class, args);
    }
}



















/*package com.example.sep6_backend;

import com.example.sep6_backend.service.PeopleService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
@EnableTransactionManagement
public class Sep6BackendApplication {

    @Autowired
    private PeopleService peopleService;
    public static void main(String[] args) {
        ConfigurableApplicationContext c = SpringApplication.run(Sep6BackendApplication.class, args);
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(); // configure your data source
        em.setPackagesToScan("com.example.sep6_backend.entity"); // specify the package(s) where your entities are located
        // other configuration properties (e.g., JPA provider, persistence unit, etc.)

        return em;
    }
/*
    public static void test(int id2) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Query peopleByIdQuery = entityManager.createNativeQuery("SELECT * FROM People p WHERE p.id = :id");
            peopleByIdQuery.setParameter("id", id2);
            List<Object[]> results = peopleByIdQuery.getResultList();

            for (Object[] result : results) {
                // Assuming the query selects all columns from the People table
                int id = (int) result[0];
                String name = (String) result[1];
                java.math.BigInteger birth = (java.math.BigInteger) result[2];

                System.out.println("Person ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Birth: " + birth);
            }

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.clear();
            entityManagerFactory.close();
        }
    }
}
 */


