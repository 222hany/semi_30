package semi.qna;

public class Paging {
	// 전체 페이지 수 구하기
	// numPerPage : 한 화면에 나타낼 데이터 갯수
	// dataCount : 전체 데이터 수
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		pageCount = dataCount/numPerPage;
		
		if(dataCount % numPerPage != 0) { // 나머지가 0이 아니면 페이지를 하나 더 만듦
			pageCount++;
		}
		return pageCount;
	}
	
	// 페이징 처리 메서드
	// currentPage : 현재 표시할 페이지
	// totalPgae : 전체 페이지 수
	// listUrl : 링크를 설정할 URL(list.jsp)
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		int numPerBlock = 10;
		int currentPageSetup; // 표시할 첫 페이지의 -1 해준 값
		int page; // 하이퍼링크가 될 page index 숫자
		
		StringBuffer sb = new StringBuffer();
		if(currentPage==0 || totalPage == 0) {
			return "";
		}
		
		// QnAList.jsp
		// QnAList.jsp?searchKey=name&searchValue=suzi 검색한 내용의 인수와 변수값이 붙음
		if(listUrl.indexOf("?") != -1){ //물음표가 있으면
			listUrl = listUrl + "&";
			//QnAList.jsp?searchKey=name&searchValue=suzi&
		} else {
			listUrl = listUrl + "?";
			// QnAList.jsp?
		}
		
		// 표시할 첫 페이지에서 -1한 값
		currentPageSetup = (currentPage/numPerBlock) * numPerBlock;
		
		// currentPage가 numPerBlock으로 나누어 떨어질 경우
		if(currentPage % numPerBlock == 0)
			currentPageSetup = currentPageSetup - numPerBlock;
		
		// 이전버튼
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<a href=\"" + listUrl +"pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp;");
			// <a href="QnAlist.jsp?pageNum=5">◀이전</a>&nbsp; 역슬래시로 쌍따옴표가 문자로 인식되게 함
		}
		
		// 바로가기 페이지
		page = currentPageSetup + 1; // currentPageSetup에 +1한 값 부터 페이지 번호가 시작됨
		
		// 바로가기 페이지는 전체 페이지 수보다 커질 수 없음
		while(page<=totalPage && page <= (currentPageSetup+numPerBlock)) {
			if(page == currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				// <font color="Fuchsia">9</font>&nbsp;
			} else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
				// <a href="QnAlist.jsp?pageNum=10">10</a>&nbsp;
			}
			page++;
		}
		
		// 다음▶, 마지막 페이지
		if(totalPage - currentPageSetup > numPerBlock) {
			// 총 페이지 12일 때, 현재 페이지가 10 페이지라면
			// numPerBlock 5 보다 작으므로 다음버튼 생성하지 않음
			sb.append("<a href=\"" + listUrl + "pageNum" + page + "\">다음▶</a>&nbsp;");
			// <a href="QnAlist.jsp?pageNum=11">다음▶</a>&nbsp;
		}
		return sb.toString();
	}
}
