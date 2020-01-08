package sp4j.jcp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.tbl.dao.CUCUIFDAO;
import sp4j.tbl.model.CUCUIF;

@Service("jcp10000Service")
public class JCP10000ServiceImpl implements JCP10000Service{

	@Resource(name="cusInfoDAO")
	private CUCUIFDAO cusInfoDAO;
	
	@Override
	public CUCUIF selectCusInfo(Map<String, Object> map) {
		return cusInfoDAO.selectCusInfo(map);
	}

	@Override
	public void insertCusInfo(Map<String, Object> map) {
		cusInfoDAO.insertCusInfo(map);
	}

}
