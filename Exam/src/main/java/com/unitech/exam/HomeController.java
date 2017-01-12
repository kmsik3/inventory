package com.unitech.exam;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unitech.exam.mapper.UsersInfoMapper;
import com.unitech.exam.model.UsersInfo;
import com.unitech.exam.model.UsersInfoExample;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		

		
		return "home";
	}
	
	@RequestMapping(value="/addUser", method= RequestMethod.POST)
	public @ResponseBody boolean addUser(
			@RequestParam(value="ndis")String ndis,
			@RequestParam(value="name")String name,
			@RequestParam(value="address")String address,
			@RequestParam(value="phone")String phone,
			@RequestParam(value="nok")String nok,
			@RequestParam(value="dob")String dob,
			@RequestParam(value="device")String device,
			@RequestParam(value="notes", required=false, defaultValue="")String notes,
			@RequestParam(value="profile")String profile
			){
		
		UsersInfoMapper usersInfoMapper = sqlSession.getMapper(UsersInfoMapper.class); 
		UsersInfo usersInfo = new UsersInfo();
		  
		usersInfo.setAddress(address);
		usersInfo.setDob(dob);
		usersInfo.setName(name);
		usersInfo.setNdis(ndis);
		usersInfo.setNok(nok);
		usersInfo.setNotes(notes);
		usersInfo.setPhone(phone);
		usersInfo.setProfile(profile);
		usersInfo.setRd(Integer.valueOf(device));
		
		usersInfoMapper.insertSelective(usersInfo);
		
		return true;
	}
	
	@RequestMapping(value="/updateUser", method= RequestMethod.POST)
	public @ResponseBody boolean updateUser(
			@RequestParam(value="targetId")String targetId,
			@RequestParam(value="ndis")String ndis,
			@RequestParam(value="name")String name,
			@RequestParam(value="address")String address,
			@RequestParam(value="phone")String phone,
			@RequestParam(value="nok")String nok,
			@RequestParam(value="dob")String dob,
			@RequestParam(value="device")String device,
			@RequestParam(value="notes", required=false, defaultValue="")String notes,
			@RequestParam(value="profile")String profile
			){
		
		UsersInfoMapper usersInfoMapper = sqlSession.getMapper(UsersInfoMapper.class); 
		UsersInfo usersInfo = usersInfoMapper.selectByPrimaryKey(targetId);
		  
		usersInfo.setAddress(address);
		usersInfo.setDob(dob);
		usersInfo.setName(name);
		usersInfo.setNdis(ndis);
		usersInfo.setNok(nok);
		usersInfo.setNotes(notes);
		usersInfo.setPhone(phone);
		usersInfo.setProfile(profile);
		usersInfo.setRd(Integer.valueOf(device));
		
		usersInfoMapper.updateByPrimaryKeySelective(usersInfo);
		
		return true;
	}
	
	@RequestMapping(value="/selectUser")
	public @ResponseBody JSONArray selectUser(){
		
		JSONArray array = new JSONArray();
		UsersInfoMapper usersInfoMapper = sqlSession.getMapper(UsersInfoMapper.class); 
		UsersInfoExample example = new UsersInfoExample();
		List<UsersInfo> list = usersInfoMapper.selectByExample(example);
		for (UsersInfo ui : list) {
			JSONObject object = new JSONObject();
			object.put("ndis", ui.getNdis());
			object.put("name", ui.getName());
			object.put("address", ui.getAddress());
			object.put("phone", ui.getPhone());
			object.put("nok", ui.getNok());
			object.put("dob", ui.getDob());
			object.put("device", ui.getRd());
			object.put("notes", ui.getNotes());
			object.put("profile", ui.getProfile());
			array.add(object);
		}
		
		return array;
	}
	
}
