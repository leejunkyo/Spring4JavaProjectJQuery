package sp4j.common.server.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.interceptor.sessionInterceptor;
import sp4j.common.model.CommandMap;
import sp4j.common.server.model.TableNm;
import sp4j.common.server.service.ServerService;
import sp4j.common.utility.StringUtil;

@Controller
public class ServerController {

	@Resource(name = "serverService")
	private ServerService serverService;

	@Value("#{config['server']}")
	String server;

	protected Log log = LogFactory.getLog(sessionInterceptor.class);
	
	@Transactional
	@RequestMapping(value = "/server/firstVisit.do")
	public ModelAndView firstVisit(CommandMap commandMap, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if(!"N".equals(StringUtil.isNullStr(session.getAttribute("firstVisit")))){
			log.debug("DB TABLE CREATE SERVER START");
			log.debug("DB SEVER : "+server);
			
			commandMap.put("serverOp", server);
			
			List<TableNm> tblList = serverService.tblList(commandMap.getMap());
			
			String path = ServerController.class.getResource("/").getPath();
	
	        path = path.substring(0, path.length() - 1);
	
	        path = path.substring(0, path.lastIndexOf("/") + 1);
			String filePath = path+"/dataBaseFile/"+server+"/"+server+"_Create.xlsx";
			
			InputStream inputStream = new FileInputStream(filePath);
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowItr = sheet.iterator();
			
			while (rowItr.hasNext()) {
				Row row = rowItr.next();

				Iterator<Cell> cellItr = row.cellIterator();
				String chkTable = "";
				while (cellItr.hasNext()) {
					boolean flag = false;
					Cell cell = cellItr.next(); 
					int index = cell.getColumnIndex();
					
					if(index == 0){
						
						chkTable = cell.toString();
						log.debug("==========================================================================================================");
						log.debug("TABLE NAME : "+chkTable);
						for(int idx = 0; idx < tblList.size(); idx++){
							if(cell.toString().equals(tblList.get(idx).getTblNm())){
								flag = true;
							}
						}
						if(flag){
							log.debug("========================                 이미생성된 TABLE                    ========================");
							break;
						}else{
							continue;
						}
					}else{
						log.debug("============================                 DB TABLE CREATE              ============================= ");
						commandMap.put("query", cell);
						serverService.exeQuery(commandMap.getMap());
						
						if(server.equals("oracle")){
							log.debug("============================                 ORACLE COMMANT CREATE       ============================= ");
							filePath = path+"/dataBaseFile/"+server+"/comment/"+chkTable+"_Create.xlsx";
							inputStream = new FileInputStream(filePath);
							
							Workbook workbook2 = WorkbookFactory.create(inputStream);
							Sheet sheet2 = workbook2.getSheetAt(0);
							Iterator<Row> rowItr2 = sheet2.iterator();
							while (rowItr2.hasNext()) {
								Row row2 = rowItr2.next();

								Iterator<Cell> cellItr2 = row2.cellIterator();
								while (cellItr2.hasNext()) {
									Cell cell2 = cellItr2.next(); 
									
									commandMap.put("query", cell2);
									serverService.exeQuery(commandMap.getMap());
								}
							}
						}
						log.debug("============================                 DB TABLE CREATE  END        ============================= ");
						
					}
				}
	
			}
				
		}
		session.setAttribute("firstVisit", "N");
		
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
		return mv;
	}
	// 셀가져오
    private static Object getValueFromCell(Cell cell) {
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";                                
        }
    }

}
