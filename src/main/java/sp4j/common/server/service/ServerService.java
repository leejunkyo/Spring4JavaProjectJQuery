package sp4j.common.server.service;

import java.util.List;
import java.util.Map;

import sp4j.common.server.model.TableNm;

public interface ServerService {

	public List<TableNm> tblList(Map<String,Object> commandMap);

	public void exeQuery(Map<String,Object> commandMap);

}
