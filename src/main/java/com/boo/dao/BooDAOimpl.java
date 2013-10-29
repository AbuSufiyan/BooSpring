package com.boo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boo.model.BooModel;

@Repository
public class BooDAOimpl implements BooDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void updateUserDetails(BooModel booModel) {

		this.sessionFactory.getCurrentSession().save(booModel);
	}

	@Override
	public List<BooModel> GetUsersList() {

		List<BooModel> booModelList = new ArrayList<BooModel>();

		String hql = "FROM BooModel";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<BooModel> results = (List<BooModel>) query.list();
		return results;
	}

}
