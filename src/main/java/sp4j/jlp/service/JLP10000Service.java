package sp4j.jlp.service;

import java.util.Map;

import sp4j.tbl.model.CUCUIF;

public interface JLP10000Service {

	public CUCUIF selectCusInfo(Map<String, Object> map);

	public void insertCusInfo(Map<String, Object> map);
}
