package sp4j.tbl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;
import sp4j.tbl.model.CUMNIF;

@Repository("cumnifDAO")
public class CUMNIFDAO extends AbstractDAO {

	public CUMNIF selectCumnif(Map<String, Object> map) {
		return (CUMNIF) selectOne("cucuif.selectCumnif", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<CUMNIF> selectCumnifList(Map<String, Object> map) {
		return (List<CUMNIF>) selectList("cucuif.selectCumnifList", map);
	}

	public void insertCumnif(Map<String, Object> map) {
		insert("cucuif.insertCumnif", map);
	}

}
