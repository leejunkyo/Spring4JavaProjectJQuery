package sp4j.jsm.service;

import java.util.List;
import java.util.Map;

import sp4j.jsm.model.JSM10110;

public interface JSM10110Service {

	List<JSM10110> selectJSM10110List(Map<String, Object> map);
	
}
