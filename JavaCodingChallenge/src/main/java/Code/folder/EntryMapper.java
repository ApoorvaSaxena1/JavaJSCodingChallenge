package folder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EntryMapper implements RowMapper<Entry>{
	@Override
	public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
		Entry entry = new Entry();
		entry.setPassenger(rs.getInt("Passenger"));
		entry.setSurvived(rs.getInt("Survived"));
		entry.setPclass(rs.getInt("Pclass"));
		entry.setName(rs.getString("Name"));
		entry.setSex(rs.getString("Sex"));
		entry.setAge(rs.getInt("Age"));
		entry.setSibSp(rs.getInt("SibSp"));
		entry.setParch(rs.getInt("Parch"));
		entry.setTicket(rs.getString("Ticket"));
		entry.setFare(rs.getFloat("Fare"));

		return entry;
	}
}

