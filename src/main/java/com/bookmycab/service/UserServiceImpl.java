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
	public User updateUser(User user) throws UserException {
		User curUser = userDao.getById(user.getUserId());
		if(curUser==null) throw new UserException("User doesn't exist with this userId : "+user.getUserId());
//		if(!user.getUsername().equals(curUser.getUsername())) {
//			curUser.setUsername(user.getUsername());
//		}
		return userDao.save(curUser);
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

}
