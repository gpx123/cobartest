package com.hj.cobar.service.impl;

import com.hj.cobar.bean.Order;
import com.hj.cobar.common.Result;
import com.hj.cobar.dao.OrderDAO;
import com.hj.cobar.query.OrderQuery;
import com.hj.cobar.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author hj
 * @since 2013-12-11
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Log log = LogFactory.getLog(OrderServiceImpl.class);

	@Resource
	OrderDAO OrderDAO;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Long addOrder(Order order) {
		try {
			return OrderDAO.addOrder(order);
		} catch (SQLException e) {
			log.error("dao addOrder error.:" + e.getMessage(), e);
		}
		return 0L;
	}

	/**
	 * 根据主键查找
	 */
	public Order getOrderByKey(Long id) {
		try {
			return OrderDAO.getOrderByKey(id);
		} catch (SQLException e) {
			log.error("dao getOrderbyKey error.:" + e.getMessage(), e);
		}
		return null;
	}

	public List<Order> getOrderByKeys(List<Long> idList) {
		try {
			return OrderDAO.getOrderByKeys(idList);
		} catch (SQLException e) {
			log.error("dao getOrdersByKeys erorr." + e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Long id) {
		try {
			return OrderDAO.deleteByKey(id);
		} catch (SQLException e) {
			log.error("dao deleteByKey error. :" + e.getMessage(), e);
		}
		return -1;
	}

	public Integer deleteByKeys(List<Long> idList) {
		try {
			return OrderDAO.deleteByKeys(idList);
		} catch (SQLException e) {
			log.error("dao deleteByKeys error. s:" + e.getMessage(), e);
		}
		return -1;
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order) {
		try {
			return OrderDAO.updateOrderByKey(order);
		} catch (SQLException e) {
			log.error("dao updateOrder error.Order:" + e.getMessage(), e);
		}
		return -1;
	}

	public Result<Order> getOrderListWithPage(OrderQuery orderQuery) {
		Result<Order> rs = OrderDAO.getOrderListWithPage(orderQuery);
		if (!rs.isSuccess()) {
			log.error("get Order error." + rs.getErrorMsg());
		}
		return rs;
	}

	public List<Order> getOrderList(OrderQuery orderQuery) {
		try {
			return OrderDAO.getOrderList(orderQuery);
		} catch (SQLException e) {
			log.error("get Order list error." + e.getMessage(), e);
		}
		return Collections.emptyList();
	}

}
