package com.boo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boo.dao.BooDAO;
import com.boo.model.BooModel;

@Transactional
@Service
public class BooService {

	@Autowired
	BooDAO boo;

	public void updateUserDetails(String fName, String lName) {
		BooModel booModel = new BooModel();
		booModel.setfName(fName);
		booModel.setlName(lName);
		boo.updateUserDetails(booModel);
	}

	public List<BooModel> GetUsersList() {
		return boo.GetUsersList();
	}
}
