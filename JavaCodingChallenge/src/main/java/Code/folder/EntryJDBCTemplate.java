package folder;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class EntryJDBCTemplate {

	public EntryJDBCTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
//
//	public Entry getStudent(Integer id) {
//		String SQL = "select * from Student where id = ?";
//		Entry entry = jdbcTemplateObject.queryForObject(SQL, 
//				new Object[]{id}, new EntryMapper());
//
//		return entry;
//	}
	
	public List<Entry> listEntry() {
		String SQL = "SELECT * FROM sakila.titanictb";
		List <Entry> entries = jdbcTemplateObject.query(SQL, new EntryMapper());
		return entries;
	}
	
}
