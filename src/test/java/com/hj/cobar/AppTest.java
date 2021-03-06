package com.hj.cobar;

import com.alibaba.cobar.client.util.SqlUtil;
import com.hj.cobar.bean.Cont;
import com.hj.cobar.bean.Order;
import com.hj.cobar.query.ContQuery;
import com.hj.cobar.query.OrderQuery;
import com.hj.cobar.service.ContService;
import com.hj.cobar.service.OrderService;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest extends AbstractTestNGSpringContextTests {
	@Resource
	private ContService contService;
	@Resource
	private OrderService orderService;
	
	/**
	 * 没有使用对象查询直接使用基本类型则到默认的数据源中去查找数据
	 */
	@Test
    public void test1(){
    	Cont cont = contService.getContByKey(2L);
    	System.out.println(cont);
    	
    }
    
    /**
     * 测试添加
     */
	@Test(invocationCount=1000,threadPoolSize=5)
    public void test2(){
    	Cont cont = new Cont();
		cont.setName("gd"+String.valueOf(new Random().nextInt(10)));
    	Long taobaoId = new Long(new Random().nextInt(10000));
    	System.out.println("#"+taobaoId);
    	cont.setTaobaoId(taobaoId);
    	contService.addCont(cont);
    }
    
    /**
     * 测试使用对象包含taobaoId属性的进行查找
     * 使用这种方式可以根据taobaoId分库查找
     */
	@Test
    public void test3(){
    	ContQuery contQuery = new ContQuery();
    	contQuery.setTaobaoId(768L);
    	List<Cont> list = contService.getContList(contQuery);
    	if(list != null){
    		System.out.println(list.get(0));
    	}
    }

	@Test
	public void test4(){
		OrderQuery orderQuery = new OrderQuery();
		orderQuery.setTaobaoId(768L);
		List<Order> list = orderService.getOrderList(orderQuery);
		if(list != null){
			System.out.println(list.get(0));
		}
	}

	/**
	 * 测试添加
	 */
	@Test(invocationCount=1000,threadPoolSize=5)
	public void test5(){
		Order order = new Order();
		order.setName("gd" + String.valueOf(new Random().nextInt(10)));
		Long taobaoId = new Long(new Random().nextInt(10000));
		System.out.println("#"+taobaoId);
		order.setTaobaoId(taobaoId);
		orderService.addOrder(order);
	}

	/**
	 * 测试group by
	 */
	@Test
	public void test6(){
		ContQuery query = new ContQuery();
		query.setNameLike(true);
		query.setName("4");
		List<Cont> list = contService.getContList(query);
		System.out.println(list.size());
	}

	@Test
	public void test7(){
		List<Map<String, Object>> list = contService.groupContList();
		System.out.println(list.size());
	}

	@Test
	public void test8(){
		List<Map<String, Object>> list = contService.groupContList2();
		System.out.println(list.size());
	}

	@Test
	public void test9(){
		OrderQuery orderQuery = new OrderQuery();
		orderQuery.setNameLike(true);
		orderQuery.setName("4");
		orderQuery.setFragmentList(new Date(),"-2,0");
		List<Order> list = orderService.getOrderList(orderQuery);
		if(list != null){
			System.out.println(list.get(0));
		}
	}
}
