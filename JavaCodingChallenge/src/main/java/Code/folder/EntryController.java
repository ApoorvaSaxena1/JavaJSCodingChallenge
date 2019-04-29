package folder;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class EntryController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    DBConnection dbconn=new DBConnection();
    ObjectToJSON obj=new ObjectToJSON();
    
    @RequestMapping("/grid")
    public String grid() {
    	
    	List<Entry> entries = dbconn.getData();
        return obj.entryToJSON(entries);
    }
    @RequestMapping("/paging/{pageNum}")
    public String paging(@PathVariable int pageNum) {
    	
    	List<Entry> entries = dbconn.getData();
        return obj.entryToJSONpaging(entries,pageNum);
    }
}
