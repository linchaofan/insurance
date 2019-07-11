package org.lcf.ins.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.lcf.ins.dao.ProductMapper;
import org.lcf.ins.dao.ProductSchemeMapper;
import org.lcf.ins.dto.AddProductDTO;
import org.lcf.ins.dto.ProductDetailDTO;
import org.lcf.ins.dto.ProductInfoDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.dto.SkuProductDTO;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.ProductExample;
import org.lcf.ins.entity.ProductScheme;
import org.lcf.ins.entity.ProductSchemeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.extcheck.Main;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductMapper productMapper;
	@Autowired
	ProductSchemeMapper productSchemeMapper;

	//根据Id获取商品信息
	public ProductInfoDTO selectProductInfo(Integer productId) {
		Product product = productMapper.selectByPrimaryKey(productId);
		if (product == null) {
			LOGGER.info("没有找到对应商品");
			return null;
		} else {
			ProductInfoDTO productInfo = new ProductInfoDTO();
			BeanUtils.copyProperties(product, productInfo);
			return productInfo;
		}
	}
	
	//根据sellerId获取商品列表
	@SuppressWarnings("unchecked")
	public ResultDTO<List<Product>> selectProductBySellerId(Integer sellerId){
		ResultDTO<List<Product>> result = ResultDTO.newSuccess();
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andSellerIdEqualTo(sellerId);
		List<Product> products = productMapper.selectByExample(example);
		if (products.size() == 0) {
			return result = ResultDTO.newFail("暂无任何商品....");
		}
		result.setData(products);
		return result;
	}

	// 根据类型查询商品列表
	@SuppressWarnings("unchecked")
	public ResultDTO<List<Product>> selectProductByTypeCode(String typeCode) {
		ResultDTO<List<Product>> result = ResultDTO.newSuccess();
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andTypeCodeEqualTo(typeCode);
		List<Product> list = productMapper.selectByExample(example);
		if (list.size() == 0) {
			return result = ResultDTO.newFail("暂无此类型的任何商品....");
		}
		result.setData(list);
		return result;
	}
	
	//根据标识码查询商品详情
	@SuppressWarnings("unchecked")
	public ResultDTO<ProductDetailDTO> selectProductDetailByCode(String productCode,HttpSession session){
		ResultDTO<ProductDetailDTO> result = ResultDTO.newSuccess();
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(productCode);
		List<Product> products = productMapper.selectByExample(example);
		ProductSchemeExample example1 = new ProductSchemeExample();
		ProductSchemeExample.Criteria criteria1 = example1.createCriteria();
		criteria1.andProductCodeEqualTo(productCode);
		List<ProductScheme> productSchemes = productSchemeMapper.selectByExample(example1);
		if(products.size()==0||productSchemes.size()==0){
			return result = ResultDTO.newFail("获取商品详情失败");
		}
		int length = productSchemes.get(productSchemes.size()-1).getAgeRange().length();
		String minAge = productSchemes.get(0).getAgeRange().substring(0, 2);
		String maxAge = productSchemes.get(productSchemes.size()-1).getAgeRange().substring(length - 2, length);
		session.setAttribute("minAge", minAge);
		session.setAttribute("maxAge", maxAge);
		Set<String> sets1 = new HashSet<String>();
		Set<String> sets2 = new HashSet<String>();
		List<String> coverageList = new ArrayList<>();
		List<String> deadLineList = new ArrayList<>();
		for(ProductScheme scheme : productSchemes){
			sets1.add(scheme.getCoverage());
			sets2.add(scheme.getDeadline());
		}
		for(String set1 : sets1){
			coverageList.add(set1);
		}
		for(String set2 : sets2){
			deadLineList.add(set2);
		}
		Product product = products.get(0);
		ProductScheme productScheme = productSchemes.get(0);
		ProductDetailDTO productDetail = new ProductDetailDTO();
		productDetail.setName(product.getName());
		productDetail.setTitle(product.getTitle());
		productDetail.setShortTitle(product.getShortTitle());
		productDetail.setImgpath(product.getImgpath());
		productDetail.setIntroduce(product.getIntroduce());
		productDetail.setNotice(product.getNotice());
		productDetail.setCompensationNote(product.getCompensationNote());
		productDetail.setQuestion(product.getQuestion());
		productDetail.setAgeRange(productScheme.getAgeRange());
		productDetail.setCoverageList(coverageList);
		productDetail.setHasSocial(productScheme.getHasSocial());
		productDetail.setDeadLineList(deadLineList);
		productDetail.setPrice(productScheme.getPrice());
		
		result.setData(productDetail);
		return result;
	}

	//插入商品方案
	@SuppressWarnings("unchecked")
	public ResultDTO<String> insertProductScheme(String skuList, String priceList, String productCode)
			throws JsonParseException, JsonMappingException, IOException {
		ResultDTO<String> result = ResultDTO.newSuccess();
		ObjectMapper mapper = new ObjectMapper();
		// JavaType jt =
		// mapper.getTypeFactory().constructParametricType(ArrayList.class,
		// SkuProductDTO.class);
		List<List<String>> skuLists = mapper.readValue(skuList, new TypeReference<List<List<String>>>() {
		});
		List<String> skuPrices = mapper.readValue(priceList, ArrayList.class);
		String code = mapper.readValue(productCode, String.class);
		// 去重
		List<List<String>> skus = new ArrayList<>();
		for (int i = 0; i < skuLists.size(); i++) {
			boolean tag = false;
			for (List<String> sku : skus) {
				if (compareList(sku, skuLists.get(i))) {
					tag = true;
					break;
				}
			}
			if (!tag) {
				skus.add(skuLists.get(i));
			}
		}

		int count = 0;
		for (int i = -(skus.size() - skuPrices.size()); i < skus.size(); i++) {
			List<String> values = new ArrayList<>();
			values = skus.get(i);
			ProductScheme productScheme = new ProductScheme();
			productScheme.setProductCode(code);
			productScheme.setAgeRange(values.get(0));
			productScheme.setCoverage(values.get(1));
			productScheme.setDeadline(values.get(2));
			productScheme.setHasSocial(values.get(3));
			productScheme.setPrice(Long.valueOf(skuPrices.get(count)));
			productSchemeMapper.insertSelective(productScheme);
			count++;
		}

		return result;
	}

	// 比较list
	public static boolean compareList(List<String> list1, List<String> list2) {
		boolean tag = true;
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return tag;
	}
	
	@SuppressWarnings("unchecked")
	public ResultDTO<String> insertProductInfo(AddProductDTO addProduct,Integer sellerId,HttpServletRequest request) throws IllegalStateException, IOException{
		ResultDTO<String> result = ResultDTO.newSuccess();
		Product product = new  Product();
		product.setCode(addProduct.getCode());
		product.setName(addProduct.getProductName());
		product.setSellerId(sellerId);
		product.setTypeCode(addProduct.getType());
		product.setTitle(addProduct.getTitle());
		product.setShortTitle(addProduct.getShortTitle());
		product.setIntroduce(addProduct.getIntroduce());
		product.setNotice(addProduct.getNotice());
		product.setCompensationNote(addProduct.getCompensationNote());
		product.setQuestion(addProduct.getQuestion());
		String imgPath = uploadPicture(addProduct.getImage(),request);
		product.setImgpath(imgPath);
		int insert = productMapper.insertSelective(product);
		if(insert==0){
			result = ResultDTO.newFail("添加失败");
			return result;
		}
		return result;
	}
	


	/**
	 * 上传图片至工程目录
	 * 返回储存路径
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String uploadPicture(MultipartFile image,HttpServletRequest request) throws IllegalStateException, IOException{
		//使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//获取文件的扩展名
		String ext = FilenameUtils.getExtension(image.getOriginalFilename());
		//设置图片上传路径
//		String url = request.getSession().getServletContext().getRealPath("/images");
		String url = "C:\\Users\\Administrator\\workspace\\insurance\\src\\main\\webapp\\images";
		//以绝对路径保存重名命后的图片
		image.transferTo(new File(url+"/"+name+"."+ext));
		String imgPath = "images/"+name+"."+ext;
		return imgPath;
	}
	
	public static void main(String[] args) {
		
	}
}
