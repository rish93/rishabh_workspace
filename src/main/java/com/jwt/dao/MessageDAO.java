package com.jwt.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

import com.jwt.model.MessageModel;





public interface MessageDAO {
	List<MessageModel> getData();
	void setMessage(Integer id,String msg,String author,java.util.Date date);
	
void updateMsg(Integer id, String msg);
List<MessageModel>getParticularMsg(Integer id);
MessageModel deleteMsg(Long id);
void deleteAllMsg();
	



}
