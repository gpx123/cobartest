package com.hj.cobar.dao;

import com.hj.cobar.bean.Order;
import com.hj.cobar.common.Result;
import com.hj.cobar.query.OrderQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hj
 * @date 2013-12-11
 */

@Repository
public class OrderDAO {

	@Resource
	SqlMapClientTemplate sqlMapClientTemplate;

	public Long addOrder(Order order) throws SQLException {
		return (Long) this.sqlMapClientTemplate.insert("Order.insertOrder", order);
	}

	/**
	 * 根据主键查找
	 *
	 * @throws java.sql.SQLException
	 */
	public Order getOrderByKey(Long id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Order result = (Order) this.sqlMapClientTemplate.queryForObject(
				"Order.getOrderByKey", params);
		return result;
	}

	/**
	 * 根据主键批量查找
	 *
	 * @throws java.sql.SQLException
	 */
	public List<Order> getOrderByKeys(List<Long> idList) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", idList);
		return (List<Order>) this.sqlMapClientTemplate.queryForList(
				"Order.getOrdersByKeys", params);
	}

	/**
	 * 根据主键删除
	 *
	 * @return
	 * @throws java.sql.SQLException
	 */
	public Integer deleteByKey(Long id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete(
				"Order.deleteByKey", params);
		return row;
	}

	/**
	 * 根据主键批量删除
	 *
	 * @return
	 * @throws java.sql.SQLException
	 */
	public Integer deleteByKeys(List<Long> idList) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", idList);
		Integer row = (Integer) this.sqlMapClientTemplate.delete(
				"Order.deleteByKeys", params);
		return row;
	}

	/**
	 * 根据主键更新
	 *
	 * @return
	 * @throws java.sql.SQLException
	 */
	public Integer updateOrderByKey(Order Order) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.update(
				"Order.updateOrderByKey", Order);
	}

	@SuppressWarnings("unchecked")
	public Result<Order> getOrderListWithPage(OrderQuery OrderQuery) {
		Result<Order> rs = new Result<Order>();
		try {
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject(
					"Order.getOrderListCount", OrderQuery));
			if (OrderQuery.getFields() != null && OrderQuery.getFields() != "") {
				rs.setList((List<Order>) this.sqlMapClientTemplate.queryForList(
						"Order.getOrderListWithPageFields", OrderQuery));
			} else {
				rs.setList((List<Order>) this.sqlMapClientTemplate.queryForList(
						"Order.getOrderListWithPage", OrderQuery));
			}
		} catch (Exception e) {
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrderList(OrderQuery OrderQuery) throws SQLException {
		if (OrderQuery.getFields() != null && OrderQuery.getFields() != "") {
			return (List<Order>) this.sqlMapClientTemplate.queryForList(
					"Order.getOrderListFields", OrderQuery);
		}
		return (List<Order>) this.sqlMapClientTemplate.queryForList(
				"Order.getOrderList", OrderQuery);
	}

}