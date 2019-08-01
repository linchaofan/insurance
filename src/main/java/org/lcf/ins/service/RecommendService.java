package org.lcf.ins.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.dto.UserSetDTO;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.User;
import org.lcf.ins.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {

	@Autowired
	OrderService orderService;

	// 获取UserSet
	@SuppressWarnings("unchecked")
	public ResultDTO<UserSetDTO> getUserSet(List<User> users) {
		ResultDTO<UserSetDTO> result = ResultDTO.newSuccess();
		UserSetDTO userSet = new UserSetDTO();
		for (User user : users) {
			ResultDTO<List<OrderInfo>> result1 = orderService.selectOrderByHolderId(user.getId());
			if (result1.getStatus() == ErrorEnum.success.getErrorCode()) {
				List<OrderInfo> orders = result1.getData();
				UserSetDTO.User u = userSet.put(user.getPhone());
				for (OrderInfo order : orders) {
					u.set(order.getProductCode());
				}
				u.create();
			}
		}
		result.setData(userSet);
		return result;
	}

	// 在给定username的情况下，计算其他用户跟它的距离并排序
	private Map<Double, String> computeNearestNeighbor(String userName, UserSetDTO set) {
		Map<Double, String> distances = new TreeMap<>();

		UserSetDTO.User u1 = set.getUser(userName);
		for (int i = 0; i < set.users.size(); i++) {
			UserSetDTO.User u2 = set.getUser(i);
			if (!u2.username.equals(userName)) {
				double distance = person_dis(u2.list, u1.list);
				if (distance == 0) {
					continue;
				}
				distances.put(distance, u2.username);
			}
		}
		return distances;
	}

	// 计算两个用户之间的距离
	private Double person_dis(List<UserSetDTO.Set> rating1, List<UserSetDTO.Set> rating2) {
		double distance = 0;
		for (int i = 0; i < rating1.size(); i++) {
			boolean tag = false;
			UserSetDTO.Set key1 = rating1.get(i);
			for (int j = 0; j < rating2.size(); j++) {
				UserSetDTO.Set key2 = rating2.get(j);
				if (key1.productCode.equals(key2.productCode)) {
					tag = true;
					break;
				}
			}
			if (!tag) {
				distance = distance + 1;
			}
		}
		return distance;
	}

	// 获取推荐
	@SuppressWarnings("rawtypes")
	public List<UserSetDTO.Set> recommend(String userName, UserSetDTO set) {
		Map<Double, String> distances = computeNearestNeighbor(userName, set);
		if (distances == null) {
			return null;
		}
		Iterator it = distances.keySet().iterator();
		String nearest = null;
		while (it.hasNext()) {
			nearest = distances.get(it.next());
			break;
		}

		List<UserSetDTO.Set> recommendations = new ArrayList<>();

		// 找到最近邻用户买过但我没买过的商品，计算推荐
		if (nearest == null) {
			return null;
		}
		UserSetDTO.User neighborRatings = set.getUser(nearest);
		UserSetDTO.User userRatings = set.getUser(userName);
		for (UserSetDTO.Set artist : neighborRatings.list) {
			if (userRatings.find(artist.productCode) == null) {
				recommendations.add(artist);
			}
		}
		Collections.sort(recommendations);
		return recommendations;
	}

	public static void main(String[] args) {
		UserSetDTO userSet = new UserSetDTO();
		userSet.put("老李").set("haha").set("hehe").set("lyb").create();
//		userSet.put("老王").set("haha").set("lyb").set("hehe").set("lcf").set("shw").create();
		userSet.put("老林").set("haha").set("hehe").set("lyb").set("gjw").create();
		userSet.put("老周").set("haha").set("hehe").set("lyb").set("st").create();
		RecommendService recommend = new RecommendService();
		List<UserSetDTO.Set> recommendations = recommend.recommend("老李", userSet);
		for (UserSetDTO.Set set : recommendations) {
			System.out.println(set.productCode);
		}
	}
}
