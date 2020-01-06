package sp4j.tbl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sp4j.common.dao.AbstractDAO;
import sp4j.tbl.model.CUS_INFO;

@Repository("cusInfoDAO")
public class CUS_INFODAO extends AbstractDAO {

	public CUS_INFO selectCusInfo(Map<String, Object> map) {
		return (CUS_INFO) selectOne("cusInfo.selectCusInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<CUS_INFO> selectCusInfoList(Map<String, Object> map) {
		return (List<CUS_INFO>) selectList("cusInfo.selectCusInfo", map);
	}

	public void insertCusInfo(Map<String, Object> map) {
		insert("cusInfo.insertCusInfo", map);
	}

}
