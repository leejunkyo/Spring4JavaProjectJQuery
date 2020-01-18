/**
 * 문자열의 바이트수 리턴
 * @returns {Number}
 */
String.prototype.byteLength = function() {
	var l= 0;
	
	for(var idx=0; idx < this.length; idx++) {
		var c = escape(this.charAt(idx));
		
		if( c.length==1 ) l ++;
		else if( c.indexOf("%u")!=-1 ) l += 2;
		else if( c.indexOf("%")!=-1 ) l += c.length/3;
	}
	
	return l;
};