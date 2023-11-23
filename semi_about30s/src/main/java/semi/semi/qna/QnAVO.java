package semi.qna;

import java.sql.Date;

public class QnAVO {
	private int qnaNo;
	private String accountID;
	private String qnaTitle;
	private String qnaText;
	private Date qnaTime;
	private int qnaHit;
	private int total;
	
	public QnAVO (int qnaNo, String accountID, String qnaTitle, String qnaText, Date qnaTime, int qnaHit) {
		this.qnaNo = qnaNo;
		this.accountID = accountID;
		this.qnaTitle = qnaTitle;
		this.qnaText = qnaText;
		this.qnaTime = qnaTime;
		this.qnaHit = qnaHit;
	}
	
	public QnAVO() {	
	}
	
	
	public QnAVO (int qnaNo, String qnaTitle, String qnaText) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaText = qnaText;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public void setQnaText(String qnaText) {
		this.qnaText = qnaText;
	}

	public void setQnaTime(Date qnaTime) {
		this.qnaTime = qnaTime;
	}
	
	public void setQnaHit(int qnahit) {
		this.qnaHit = qnaHit;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public String getAccountID() {
		return accountID;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public String getQnaText() {
		return qnaText;
	}

	public Date getQnaTime() {
		return qnaTime;
	}
	
	public int getQnaHit() {
		return qnaHit;
	}
	
	public int getTotal() {
		return total;
	}
}

