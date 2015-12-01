package dao;

import java.util.List;

import javax.transaction.Transactional;

import model.Test;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;


public class TestDaoImpl implements TestDao {
	private SessionFactory sessionFactory;
	
	public TestDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Test> list() {
		@SuppressWarnings("unchecked")
		List<Test> list = (List<Test>)sessionFactory.getCurrentSession()
		                   .createCriteria(Test.class)
		                   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}
}