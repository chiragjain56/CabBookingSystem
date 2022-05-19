package com.bookmycab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmycab.exceptions.CabException;
import com.bookmycab.exceptions.UserException;
import com.bookmycab.model.User;
import com.bookmycab.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(User user) throws UserException {
		return userDao.save(user);
	}

	@Override
	public User updateUser(Integer id ,User user) throws UserException {
		User curUser = userDao.getById(id);
		if(curUser==null) throw new UserException("User doesn't exist with this userId : "+id);
		curUser.setUsername(user.getUsername());
		curUser.setName(user.getName());
		curUser.setEmail(user.getEmail());
		curUser.setPassword(user.getPassword());
		curUser.setMobileNo(user.getMobileNo());
		final User finalUser = curUser;
		return userDao.save(finalUser);
	}

	@Override
	public User deleteUser(Integer id) throws UserException{
		User delUser = userDao.findById(id).orElseThrow(() -> new CabException("User doesn't exist with id : " + id));
		userDao.delete(delUser);
		return delUser;
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		return userDao.findById(id).orElseThrow(() -> new CabException("User doesn't exist with id : " + id));
	}

	@Override
	public User getUserByUsername(String username) throws UserException {
		return userDao.findByUsername(username);
	}

}
