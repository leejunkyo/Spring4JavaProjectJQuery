package sp4j.common.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;
import sp4j.common.server.model.TableNm;

@Repository("ServerDAO")
public class ServerDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<TableNm> selectTblList(Map<String,Object> commandMap) {
		return (List<TableNm>) selectList("server.selectTblList", commandMap);
	}
	
	public void exeQuery(Map<String,Object> commandMap) {
		 insert("server.exeQuery", commandMap);
	}
	
}
