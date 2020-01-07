package sp4j.common.utility;

public class StringUtil {
	/** null 데이터를 string으로 변환 */
	public static String isNullStr(Object str){
		String result = "";
		if(str == null){
			result = "";
		}else{
			result = str.toString();
		}
		return result;
	}
}
