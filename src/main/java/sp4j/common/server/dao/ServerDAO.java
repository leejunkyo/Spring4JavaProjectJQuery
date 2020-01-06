package sp4j.common.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;

@Repository("ServerDAO")
public class ServerDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectTblList() {
		return (List<Map<String,Object>>) selectList("server.selectTblList", "");
	}
	
}
