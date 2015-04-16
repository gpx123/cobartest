package com.hj.cobar.service;

import com.hj.cobar.bean.Order;
import com.hj.cobar.common.Result;
import com.hj.cobar.query.OrderQuery;

import java.util.List;

/**
 * @author hj
 * @since 2013-12-11
 */
public interface OrderService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Long addOrder(Order order);

	/**
	 * 根据主键查询
	 */
	public Order getOrderByKey(Long id);

	/**
	 * 根据主键批量查询
	 */
	public List<Order> getOrderByKeys(List<Long> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Long id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Long> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	public Result<Order> getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	public List<Order> getOrderList(OrderQuery orderQuery);
}
