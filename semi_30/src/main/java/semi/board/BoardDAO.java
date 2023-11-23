package semi.board;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String user ="thirties";
	String pw = "3030";
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Board> getAllBoard(){
		List<Board> boards = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM BOARD";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int boardno = resultSet.getInt("BOARD_NO");
				String boardTitle = resultSet.getString("BOARD_TITLE");
				Date boardtime = resultSet.getDate("BOARD_TIME");
				String bid = resultSet.getString("ACCOUNT_ID");
				int boardhit = resultSet.getInt("BOARD_HIT");
				Board board = new Board(boardno,boardTitle,boardtime,bid,boardhit);
				boards.add(board);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boards;
	}
	
	

	public Board getBoardno(int boardno ) {
		Board board = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM BOARD WHERE BOARD_NO=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,boardno);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				boardno = resultSet.getInt("BOARD_NO");
				String boardTitle = resultSet.getString("BOARD_TITLE");
				String boardText= resultSet.getString("BOARD_TEXT");
				String bid = resultSet.getString("ACCOUNT_ID");
				int boardhit = resultSet.getInt("BOARD_HIT");
				Date boardtime = resultSet.getDate("BOARD_TIME");
				boardhit++;
				boardHitUpdate(boardhit, boardno);
			board = new Board(boardTitle,boardText,boardhit,bid,boardtime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}
	public int boardHitUpdate(int boardhit, int boardno) {
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			String SQL = "UPDATE BOARD SET BOARD_HIT = ? where BOARD_NO = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, boardhit);//臾쇱쓬�몴�쓽 �닚�꽌
			ps.setInt(2, boardno);
			return ps.executeUpdate();//insert,delete,update			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	public String image(int boardno) {
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT BOARD_FILE FROM BOARD WHERE BOARD_NO=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,boardno);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				Blob blob = resultSet.getBlob("BOARD_FILE");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64, " + imageBase64;
                return imageUrl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	public int update(Board board) {
		Connection connection;
		String sql = "UPDATE BOARD SET BOARD_TITLE = ?,BOARD_TEXT= ? WHERE BOARD_NO  =?";
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(url, user, pw);
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1,board.getBoardTitle());
			ps.setString(2,board.getBoardText());
			ps.setInt(3,board.getBoardno());
			return ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		
		}
	return -1;
	}
	public int delete(int boardno) {
		int result = 0;
		
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pw);
			
			String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, boardno);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}


