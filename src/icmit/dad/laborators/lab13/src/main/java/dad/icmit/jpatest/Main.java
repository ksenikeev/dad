package icmit.dad.laborators.lab13.src.main.java.dad.icmit.jpatest;

import dad.icmit.jpatest.domain.Merchandise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab13");
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Merchandise m1 = new Merchandise();

        m1.setId(1L);
        m1.setName("Телевизор");
        m1.setArticle("109-2121394");

        Merchandise m2 = new Merchandise();

        m2.setId(2L);
        m2.setName("Холодильник");
        m2.setArticle("119-2325394");
        
        em.getTransaction().begin();

        // Сохраняем в БД
        em.persist(m1);
        em.persist(m2);
        
        em.getTransaction().commit();

        // поиск по id
        Merchandise merch = em.find(Merchandise.class, 2L);
        System.out.println("Merchandise: "+merch.getId()+" "+merch.getName()+
        		" "+ merch.getArticle());
        
        // Список товаров
        Query query = em.createQuery("select m from Merchandise m");
        List<Merchandise> resultList = query.getResultList();
        
        for (Merchandise m : resultList) {
        	System.out.println("Merchandise: "+m.getId()+" "+m.getName()+
            		" "+ m.getArticle());
        }
        
        em.close();
        emf.close();
    }
}
