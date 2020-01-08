package sp4j.jcp.service;

import java.util.Map;

import sp4j.tbl.model.CUCUIF;

public interface JCP10000Service {

	public CUCUIF selectCusInfo(Map<String, Object> map);

	public void insertCusInfo(Map<String, Object> map);
}
