package semi.board;

import java.io.File;
import java.sql.Date;

public class Board {
	private int boardno;
	private String boardTitle;
	private String boardText;
	private Date boardtime;
	private String bid;
	private int boardhit;
	

	public Board() {
		super();
	}
	public Board(String boardTitle,String boardText,int boardhit,String bid, Date boardtime) {
		this.boardTitle = boardTitle;
		this.boardText = boardText;
		this.boardhit = boardhit;
		this.bid = bid;
		this.boardtime = boardtime;
	}
	public Board(String bid) {
		this.bid = bid;
	}
	public Board(int boardno,String boardTitle,Date boardtime,String bid,int boardhit){
		super();
		this.boardno=boardno;
		this.boardTitle=boardTitle;
		this.boardtime = boardtime;
		this.bid=bid;
		this.boardhit=boardhit;
	
	}	
	public Board(String boardTitle,String boardText,int boardhit){
		super();
		this.boardTitle=boardTitle;
		this.boardText=boardText;
		this.boardhit=boardhit;
	}
	public Board( int boardno,String boardTitle, String boardText) {
		super();
		this.boardno=boardno;
		this.boardTitle=boardTitle;
		this.boardText=boardText;
		
	}
		
	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}


	public Date getBoardtime() {
		return boardtime;
	}

	public void setBoardtime(Date boardtime) {
		this.boardtime = boardtime;
	}


	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardText() {
		return boardText;
	}

	public void setBoardText(String boardText) {
		this.boardText = boardText;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public int getBoardhit() {
		return boardhit;
	}
	public void setBoardhit(int boardhit) {
		this.boardhit = boardhit;
	}
	
}
