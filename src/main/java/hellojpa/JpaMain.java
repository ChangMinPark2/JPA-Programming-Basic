package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloA");
            // 여기까지 비영속 상태

            em.persist(member); //1차캐시 저장
            // 영속 상태

            Member findMember = em.find(Member.class, 100L);

            System.out.println("--------------" + findMember.getId());
            System.out.println("--------------" + findMember.getName());
            // DB에서 select문 가져오는게 아닌, 1차캐시에서 가져옴.

            tx.commit();
            //DB에 쿼리가 나가는 시점
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
