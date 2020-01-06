package sp4j.jlp.service;

import java.util.Map;

import sp4j.tbl.model.CUS_INFO;

public interface JLP10000Service {

	public CUS_INFO selectCusInfo(Map<String, Object> map);

	public void insertCusInfo(Map<String, Object> map);
}
