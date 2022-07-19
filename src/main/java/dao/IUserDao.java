package dao;

import java.util.List;

import beans.user;

public interface IUserDao<T> {
	T checkLogin(String email, String password);
}
