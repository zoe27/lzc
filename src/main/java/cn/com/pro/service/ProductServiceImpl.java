package cn.com.pro.service;


import cn.com.pro.mapper.ProductMapper;
import cn.com.pro.vo.Product;
import com.alibaba.fastjson.JSON;
import com.google.common.cache.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private JRedisService jRedisService;

	private static LoadingCache<Integer, List<Product>> cache = CacheBuilder.newBuilder().maximumSize(1000)
			.expireAfterAccess(1000, TimeUnit.SECONDS)
			.removalListener(new RemovalListener<Object, Object>() {
				@Override
				public void onRemoval(RemovalNotification<Object, Object> notification) {
					System.out.println("");
				}
			})
			.build(new CacheLoader<Integer, List<Product>>() {
				@Override
				public List<Product> load(Integer key)  {
					return new ArrayList<Product>();
				}
			});

	@Override
	public Product findById(int id) {
		return null;
	}

	/**
	 * 查找最新商品
	 *
	 * @param pageable
	 * @return
	 */
	@Override
	public List<Product> findNewProduct(Pageable pageable) {
		// 查找两周内上架的商品
		// Calendar calendar = Calendar.getInstance();
		// calendar.add(Calendar.DAY_OF_MONTH, -14);
		Integer key = pageable.getPageNumber() + pageable.getPageSize();
		List<Product> products = null;
		try {
			products = cache.get(key);
			if (!products.isEmpty()){
				System.out.println("get from cache");
				return products;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		String redisProduct = jRedisService.getClient().get(key.toString());
		if (StringUtils.isNotBlank(redisProduct)){
			List<Product> array = JSON.parseArray(redisProduct, Product.class);
			products = array;
			return products;
		}

		products = productMapper.findNew(pageable);
		if (null != products){
			cache.put(key, products);
			jRedisService.getClient().set(key.toString(), JSON.toJSONString(products));
		}
		return products;

	}

	@Override
	public void update(Product product) {
		productMapper.insert(product);
	}

	@Override
	public int create(Product product) {
		return productMapper.insert(product);
	}

	@Override
	public void delById(int id) {
	}

	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		return productMapper.selectAll();
	}


}
