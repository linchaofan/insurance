package org.lcf.ins.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lcf.ins.dto.AddProductDTO;
import org.lcf.ins.dto.ProductDetailDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.dto.UserSetDTO;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.User;
import org.lcf.ins.enums.ErrorEnum;
import org.lcf.ins.service.DeleteService;
import org.lcf.ins.service.OrderService;
import org.lcf.ins.service.ProductService;
import org.lcf.ins.service.RecommendService;
import org.lcf.ins.service.SearchService;
import org.lcf.ins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMethod;
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

<<<<<<< HEAD
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	DeleteService deleteService;
	@Autowired
	SearchService searchService;
	@Autowired
	UserService userService;
	@Autowired
	RecommendService recommendService;
	@Autowired
	OrderService orderService;
	
	//根据sellerId获取产品列表
	@RequestMapping(value = "/productList")
	public String getProductList(Model model,Integer sellerId,HttpSession session){
<<<<<<< HEAD
		session.removeAttribute("errorMsg");
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
		ResultDTO<List<Product>> result = productService.selectProductBySellerId(sellerId);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorProductList";
		}
		List<Product> productList = result.getData();
		session.setAttribute("productList", productList);
		return "/productList";
	}

	//根据商品类型获取商品列表
	@RequestMapping(value = "/getProduct")
	public String getProductInfo(Model model,String typeCode,HttpSession session) {
		ResultDTO<List<Product>> result = productService.selectProductByTypeCode(typeCode);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorProductList";
		}
		List<Product> productList = result.getData();
		session.setAttribute("productList", productList);
		return "/productList";
	}

	@RequestMapping(value = "/productDetail")
	public String getProductDetail(Model model,String productCode,HttpSession session){
<<<<<<< HEAD
		ResultDTO<ProductDetailDTO> result = productService.selectProductDetailByCode(productCode,session);
=======
		ResultDTO<ProductDetailDTO> result = productService.selectProductDetailByCode(productCode);
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "errorProductList";
		}
		ProductDetailDTO productDetail = result.getData();
		session.setAttribute("productDetail", productDetail);
		session.setAttribute("productCode", productCode);
		return "productDetail";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addProductScheme")
	public String addProductScheme(String skuList,String priceList,String productCode) {
		ResultDTO<String> result = ResultDTO.newSuccess();
		try {
			result = productService.insertProductScheme(skuList, priceList, productCode);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			return result.getMessage();
		}
		return result.getMessage();
	}
	
	
	@RequestMapping(value = "/addProductInfo")
	public String addProductInfo(Model model,AddProductDTO addProduct,Integer sellerId,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
		ResultDTO<String> result  = productService.insertProductInfo(addProduct, sellerId, request);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "addProductInfo";
		}
		session.setAttribute("productCode", addProduct.getCode());
		return "addProductScheme";
	}
	
	@RequestMapping(value = "/deleteProduct")
	public String deleteProduct(Model model,Integer sellerId,HttpSession session){
		ResultDTO<List<Product>> result = productService.selectProductBySellerId(sellerId);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/deleteProduct";
		}
		List<Product> productList = result.getData();
		session.setAttribute("productList", productList);
		return "/deleteProduct";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/delete")
	public String delete(Model model,String productCode,HttpSession session){
		ResultDTO<String> result = deleteService.deleteProduct(productCode);
		return  "successDel";
	}
	
	//搜索商品
	@RequestMapping(value = "/search")
	public String search(Model model,String productName,String productType,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
<<<<<<< HEAD
		session.removeAttribute("searchProducts");
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
		session.removeAttribute("productCodes");
		session.removeAttribute("products");
		ResultDTO<List<Product>> result = searchService.searchProduct(productName, productType);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "right";
		}
		List<Product> searchProducts = result.getData();
		session.setAttribute("searchProducts", searchProducts);
		return "right";
	}
	
	//为您推荐
	@RequestMapping(value = "/recommend")
	public String recommend(Model model,String userPhone,Integer userId,HttpSession session){
		session.removeAttribute("productCodes");
		session.removeAttribute("products");
		session.removeAttribute("searchProducts");
		ResultDTO<List<OrderInfo>> orderResult = orderService.selectOrderByHolderId(userId);
		if(orderResult.getStatus()!=ErrorEnum.success.getErrorCode()){
			return "right";
		}
		ResultDTO<List<User>> result = userService.selectAllUsers();
		List<User> users = result.getData();
		ResultDTO<UserSetDTO> result1 = recommendService.getUserSet(users);
		UserSetDTO userSet = result1.getData();
		List<UserSetDTO.Set> recommendations = recommendService.recommend(userPhone, userSet);
		if(recommendations==null){
			return "right";
		}
		List<ProductDetailDTO> productDetails = new ArrayList<>();
		List<String> productCodes = new ArrayList<>();
		for(UserSetDTO.Set set : recommendations){
<<<<<<< HEAD
			ResultDTO<ProductDetailDTO> result2 = productService.selectProductDetailByCode(set.productCode,session);
=======
			ResultDTO<ProductDetailDTO> result2 = productService.selectProductDetailByCode(set.productCode);
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
			ProductDetailDTO productDetail = result2.getData();
			productCodes.add(set.productCode);
			productDetails.add(productDetail);
		}
		session.setAttribute("productCodes", productCodes);
		session.setAttribute("products", productDetails);
		return "right";
	}
<<<<<<< HEAD
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCodes")
	public Model getCodes(Model model,HttpSession session){
		Object obj = session.getAttribute("productCodes");
		List<String> productCodes = (List<String>) obj;
		if(productCodes.size()==0){
			return null;
		}
		JSONArray json = JSONArray.fromObject(productCodes);
		model.addAttribute("productCodes", json);
		return model;
	}
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
}
