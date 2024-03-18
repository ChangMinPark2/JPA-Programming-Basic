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

            Member findMember = em.find(Member.class, 100L);
            //첫 번째 조회 후, 1차 캐시에 저장해서
            //다음 쿼리에는 select문 쿼리가 안 나간다. 1차캐시에서 가져온다.
            Member findMember2 = em.find(Member.class, 100L);

            // System.out.println("--------------" + findMember.getId());
            // System.out.println("--------------" + findMember.getName());
            //
            // System.out.println("--------------" + findMember2.getId());
            // System.out.println("--------------" + findMember2.getName());


            //SQL 쓰기 지연에 insert쿼리를 날리는게 아닌 쌓아둔다.
            //1차 캐시에 Member 101, A를 넣어둔다.

            // Member member = em.find(Member.class, 100L);
            // member.setName("변경감지테스트");

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
