package sp4j.tbl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;
import sp4j.tbl.model.CUCUIF;

@Repository("cusInfoDAO")
public class CUCUIFDAO extends AbstractDAO {

	public CUCUIF selectCusInfo(Map<String, Object> map) {
		return (CUCUIF) selectOne("cucuif.selectCusInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<CUCUIF> selectCusInfoList(Map<String, Object> map) {
		return (List<CUCUIF>) selectList("cucuif.selectCusInfo", map);
	}

	public void insertCusInfo(Map<String, Object> map) {
		insert("cucuif.insertCusInfo", map);
	}

}
