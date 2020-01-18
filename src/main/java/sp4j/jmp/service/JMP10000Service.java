package sp4j.jmp.service;

import java.util.List;
import java.util.Map;

import sp4j.tbl.model.CUCUIF;
import sp4j.tbl.model.CUMNIF;

public interface JMP10000Service {

	List<CUMNIF> selectCUMNIFList(Map<String, Object> map);
	
}
