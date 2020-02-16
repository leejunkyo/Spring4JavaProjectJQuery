package sp4j.jsm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.jsm.dao.JSM10110DAO;
import sp4j.jsm.model.JSM10110;

@Service("jsm10110Service")
public class JSM10110ServiceImpl implements JSM10110Service{

	@Resource(name="jsm10110DAO")
	private JSM10110DAO jsm10110DAO;

	@Override
	public List<JSM10110> selectJSM10110List(Map<String, Object> map) {
		return jsm10110DAO.selectJSM10110List(map);
	}
}
