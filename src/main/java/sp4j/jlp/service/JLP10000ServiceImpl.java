package sp4j.jlp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.tbl.dao.CUS_INFODAO;
import sp4j.tbl.model.CUS_INFO;

@Service("jlp10000Service")
public class JLP10000ServiceImpl implements JLP10000Service{

	@Resource(name="cusInfoDAO")
	private CUS_INFODAO cusInfoDAO;
	
	@Override
	public CUS_INFO selectCusInfo(Map<String, Object> map) {
		return cusInfoDAO.selectCusInfo(map);
	}

	@Override
	public void insertCusInfo(Map<String, Object> map) {
		cusInfoDAO.insertCusInfo(map);
	}

}
