package com.boo.dao;

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
}
