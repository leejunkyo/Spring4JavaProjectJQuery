package sp4j.jsm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.jsm.dao.JSM10110DAO;

@Service("jsm10110Service")
public class JSM10110ServiceImpl implements JSM10110Service{

	@Resource(name="jsm10110DAO")
	private JSM10110DAO jsm10110DAO;

	@Override
	public List<Map<String, Object>> chatList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return jsm10110DAO.chatList(map);
	}

}
