package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestService {
    @Autowired
    private CountDigitsDao dao;

    @RequestMapping(value = "/countDigits", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CountDigitsEntity countDigits(@RequestParam(value = "str", defaultValue = "") String str){
        CountDigitsEntity count = new CountDigitsEntity(str);
        dao.store(count);
        return count;
    }

    @RequestMapping(value = "/listProcessedStrings", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Integer> listProcessedStrings() {
        Map<String, Integer> map = new HashMap<>();
        List<CountDigitsEntity> listEntities = dao.getAll();

        for (CountDigitsEntity entity : listEntities) {
            map.put(entity.getString(), entity.getCount());
        }
        return map;
    }
}
