package sp4j.jmp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp4j.tbl.dao.CUMNIFDAO;
import sp4j.tbl.model.CUMNIF;

@Service("jmp10000Service")
public class JMP10000ServiceImpl implements JMP10000Service{

	@Resource(name="cumnifDAO")
	private CUMNIFDAO cumnifDAO;

	@Override
	public List<CUMNIF> selectCUMNIFList(Map<String, Object> map) {
		return cumnifDAO.selectCumnifList(map);
	}
}
