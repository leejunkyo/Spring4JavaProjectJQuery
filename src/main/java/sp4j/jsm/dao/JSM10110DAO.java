package sp4j.jsm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;
import sp4j.jsm.model.JSM10110;

@Repository("jsm10110DAO")
public class JSM10110DAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<JSM10110> selectJSM10110List(Map<String, Object> map) {
		return (List<JSM10110>) selectList("jsm10110.jsm10110List", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> chatList(Map<String,Object> map) {
		return (List<Map<String, Object>>) selectList("jsm10110.chatList", map);
	}

}
