package sp4j.common.server.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.common.server.dao.ServerDAO;
import sp4j.common.server.model.TableNm;

@Service("serverService")
public class ServerServiceImpl implements ServerService{
	
	@Resource(name="ServerDAO")
	private ServerDAO serverDAO;
	
	@Override
	public List<TableNm> tblList(Map<String,Object> commandMap) {
		// TODO Auto-generated method stub
		return serverDAO.selectTblList(commandMap);
	}

	@Override
	public void exeQuery(Map<String,Object> commandMap) {
		serverDAO.exeQuery(commandMap);
	}
	

}
