package semi.qna;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QnADAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String userName = "thirties";
	private static final String password = "3030";
	private static Connection connection;
	
	public QnADAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<QnAVO> getAllQnAs(){
		List<QnAVO> qnas = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			
			/*String vpage = request.getParameter("vpage");
			if(vpage == null) {
				vpage = "1";
			}
			
			int qpage = Integer.parseInt(vpage);
			
			int indexNo = (qpage -1) * 10; */
			
			
			String sql = "SELECT * FROM board_qna ORDER BY qna_no DESC "; // LIMIT 시작번호, 출력개수
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet resultSet = ps.executeQuery();
			
			
			while(resultSet.next()) {
				int qnaNo = resultSet.getInt("qna_no");
				String accountID = resultSet.getString("account_id");
				String qnaTitle = resultSet.getString("qna_title");
				String qnaText = resultSet.getString("qna_text");
				Date qnaTime = resultSet.getDate("qna_time");
				int qnaHit = resultSet.getInt("qna_hit");
				
				QnAVO qna = new QnAVO(qnaNo, accountID, qnaTitle, qnaText, qnaTime, qnaHit);
				qnas.add(qna);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return qnas;
	}
	
	
	/*
	public QnA getQnaAccount(String accountsID) {
		QnA qna = null;
		// select해서 하나만 볼 수 있는 쿼리 작성하고 new Product 이용해서 값 가져오기
		String selectSql = "SELECT * FROM board_qna WHERE account_id = ?";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
			PreparedStatement ps = connection.prepareStatement(selectSql);
			
			ps.setString(1, accountsID);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				int qnaNo = resultSet.getInt("qnaNO");
				String accountID = resultSet.getString("accountID");
				String qnaTitle = resultSet.getString("qnaTitle");
				String qnaText = resultSet.getString("qnaText");
				Date qnaTime = resultSet.getDate("qnaTime");
				
				qna = new QnA (qnaNo, accountID, qnaTitle, qnaText, qnaTime);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qna;
	}*/

	public QnAVO getQnaNo(int qnaNos) {
		QnAVO qna = null;
		String selectSql = "SELECT * FROM board_qna WHERE qna_no = ?";
	
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			PreparedStatement ps = connection.prepareStatement(selectSql);
			ps.setInt(1, qnaNos);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				int qnaNo = resultSet.getInt("qna_NO");
				String accountID = resultSet.getString("account_ID");
				String qnaTitle = resultSet.getString("qna_Title");
				String qnaText = resultSet.getString("qna_Text");
				Date qnaTime = resultSet.getDate("qna_Time");
				int qnaHit = resultSet.getInt("qna_Hit");
				qnaHit++;
				qnaHitUpdate(qnaHit, qnaNo);
				qna = new QnAVO (qnaNo, accountID, qnaTitle, qnaText, qnaTime, qnaHit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qna;
	}
	
	
	
	public int updateQnA(QnAVO qna) { 
		
		String SQL = "UPDATE board_qna SET qna_title = ?, qna_text = ? WHERE qna_no = ?";
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);

	        ps = connection.prepareStatement(SQL);
	        ps.setString(1, qna.getQnaTitle());
	        // ps.setString(1, qna.getQnaTitle());
	        ps.setString(2, qna.getQnaText());
	        ps.setInt(3, qna.getQnaNo());
	        return ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return -1;
	}
	
	
	
	
	public int delete(int qnaNo) {
		int result = 0;
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
			
			String sql = "DELETE FROM board_qna WHERE qna_no = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int total() {
		int total = 0;
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
			
			String sql = "SELECT count(*) AS total FROM board_qna";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			if(result.next()){
				total = result.getInt(1); // 데이터가 없으면 null이고 return 0값이 된다.
				//count = rs.getInt("count(*)"); 위와 동일한 결과
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public int qnaHitUpdate(int qnaHit, int qnaNo) {
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
			String SQL = "UPDATE board_qna SET qna_hit = ? where qna_no = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, qnaHit);//물음표의 순서
			ps.setInt(2, qnaNo);
			return ps.executeUpdate();//insert,delete,update			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//데이터베이스 오류
	}
}
