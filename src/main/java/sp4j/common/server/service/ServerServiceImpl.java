package sp4j.common.server.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.common.server.dao.ServerDAO;

@Service("serverService")
public class ServerServiceImpl implements ServerService{
	
	@Resource(name="ServerDAO")
	private ServerDAO serverDAO;
	
	@Override
	public List<Map<String, Object>> tblList() {
		// TODO Auto-generated method stub
		return serverDAO.selectTblList();
	}
	

}
