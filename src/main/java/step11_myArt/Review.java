package step11_myArt;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import util.DBUtil;

public class Review {
	
	@Test
	public void reviwewTest() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			//create
//			em.persist(new Dept1(50, "fisa", "seoul")); // 데이터 추가할 시?
//			Dept1 newDept = new Dept1(70, "fisa", "seoul");
			Dept1 newDept = em.find(Dept1.class, 70);
//			em.persist(newDept);
			
			//select (read) : 키값으로 구하기
			System.out.println("-- dept 조회 : " + em.find(Dept1.class, 40));
			System.out.println("-- emp 조회 : " + em.find(Emp1.class, 7839));
			
			/*
			 * <트러블슈팅>
			 * java.lang.IllegalArgumentException: org.hibernate.QueryException
			 * : could not resolve property: deptno of: step11_myArt.Dept1
			 * --> Entity에 설정한 필드명으로 설정해줘야함 **
			 */
			//select : 부서 번호가 40 이상인 부서 번호들만 합을 구하기
			int deptnoSum = em.createQuery("select d from Dept1 d where d.deptno > 30", Dept1.class)
					      .getResultStream()
					      .mapToInt(Dept1::getDeptNo).sum();
			
			System.out.println(deptnoSum);

			
			//update
		//	newDept.setLoc("Bali");
			
			//delete
			em.remove(newDept);
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
	}
}
