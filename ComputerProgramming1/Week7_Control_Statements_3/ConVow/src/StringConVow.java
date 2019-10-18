class StringConVow {
	
	public void NumOfConVow(String text) {
		
		int nCon = 0; //자음의 개수
		int nVow = 0; //모음의 개수
		
		//text를 한 글자씩 순회
		for(int i = 0; i < text.length(); i++) {
					
			text = text.toLowerCase();
			char ch = text.charAt(i);
			
			if(ch < 97 || ch > 122) //알파벳이 아니라면
				continue; //다음 문자로 패스
			
			switch(ch) {

			//ch가 a,e,i,o,u중 하나라면
			case 'a': case 'e': case 'i': case 'o': case 'u':
				nVow++; //모음의 개수 += 1
				break;
				
			default: //그 외의 글자라면
				nCon++; //자음의 개수 += 1
				break;
			}
		}
		
		System.out.printf("자음은 %d개, 모음은 %d개", nCon, nVow);
		
	}
	
}