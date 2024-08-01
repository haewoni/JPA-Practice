package review;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import util.DBUtil;

public class Review {
	
	@Test
	public void reviwewCreate() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			// CRUD 적용
			
			// Create
			Dept1 newDept = new Dept1(55, "fisa", "seoul");
			em.persist(newDept);
			
			System.out.println("-- dept 조회 : " + em.find(Dept1.class, 10));

			tx.commit();
			em.clear();
			
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
	
	@Test
	public void reviwewRead() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			// CRUD 적용
			
			// Read = select
			System.out.println("-- dept 조회 : " + em.find(Dept1.class, 40)); //join 되어있지 않아 값이 출력 되지 않음
			System.out.println("-- emp 조회 : " + em.find(Emp1.class, 7839));
			
			int deptnoSum = em.createQuery("select d from Dept1 d where d.deptNo > 30", Dept1.class)
				      		.getResultStream()
				      		.mapToInt(Dept1::getDeptNo).sum();
			
			tx.commit();
			em.clear();
			
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
	
	@Test
	public void reviwewUpdate() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			
			// CRUD 적용
			Dept1 deptRes = em.find(Dept1.class, 10);
			Emp1 empRes = em.find(Emp1.class, 7839);
			System.out.println("-- dept 조회 : " + deptRes);
			System.out.println("-- emp 조회 : " + empRes);
			
			// Update - 
			tx.begin();
			
			deptRes.setDName("FENCING");
			empRes.setEName("오상욱");
			
			tx.commit();
			em.clear();
			
			System.out.println("-- dept dname field 업데이트 후 조회 : " + em.find(Dept1.class, 10));
			System.out.println("-- emp ename field 업데이트 후 조회 : " + em.find(Emp1.class, 7839));
			
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
	
	@Test
	public void reviwewDelete() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			
			// CRUD 적용
			Dept1 deptRes = em.find(Dept1.class, 60);
			System.out.println("-- Delete 전 dept 조회 : " + deptRes);
			
			// Delete = remove
			tx.begin();
			em.remove(deptRes);
			tx.commit();
			em.clear();
			
			System.out.println("-- Delete 후 dept 조회 : " + em.find(Dept1.class, 60));
			
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
