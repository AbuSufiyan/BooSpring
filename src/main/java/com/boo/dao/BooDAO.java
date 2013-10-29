package com.boo.dao;

import java.util.List;

import com.boo.model.BooModel;

public interface BooDAO {

	public void updateUserDetails(BooModel booModel);

	public List<BooModel> GetUsersList();

}
