package es;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author wen17
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/es")
public class RestController {

	@Autowired
	private YonghuiESDao dao;

	@GetMapping("execute")
	public void execute( @RequestParam(name="name") String name ) throws Exception {

		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("price_level_code", "4"))
				.must(QueryBuilders.termQuery("range_code", "10"));
		Pageable page = PageRequest.of(0, 10000);
		Iterable<ESEntity> result = this.dao.search(queryBuilder, page );
		Iterator<ESEntity> iterator = result.iterator();
		
		File file = new File("E:\\Administrator\\desktop\\file\\ids.txt");
		FileWriter fileWriter = new FileWriter(file, true);
//		FileOutputStream out = new FileOutputStream(file);
//		BufferedOutputStream bos = new BufferedOutputStream(out);
//		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			ESEntity entity = iterator.next();
//			sb.append("'" + entity.getId() + "',\n");
			fileWriter.append("'" + entity.getId() + "',\n");
		}
		fileWriter.close();
//		bos.write( sb.toString().getBytes() );
//		bos.close();
//		out.close();
	}

}
