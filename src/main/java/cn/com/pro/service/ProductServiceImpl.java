package cn.com.pro.service;


import cn.com.pro.mapper.ProductMapper;
import cn.com.pro.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	// @Autowired
	// private ClassificationDao classificationDao;

	/*private static LoadingCache<Integer, Product> cache = CacheBuilder.newBuilder().maximumSize(1000)
			.build(new CacheLoader<Integer, Product>() {
				@Override
				public Product load(Integer key) throws Exception {
					return null;
				}
			});
*/
	@Override
	public Product findById(int id) {
		/*try {
			if(cache.get(id) != null) {
				return cache.get(id);
			}
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
//		return productMapper.selectByPrimaryKey(id);
	}

	// @Override
	// public Page<Product> findAll(Pageable pageable) {
	// return productDao.findAll(pageable);
	// }

	/**
	 * 查找热门商品
	 *
	 * @return
	 */
	// @Override
	// public List<Product> findHotProduct() {
	// return productDao.findByIsHot(1, null);
	// }

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
		return productMapper.findNew(pageable);
	}

	/**
	 * 根据一级分类查找商品
	 *
	 * @param cid
	 * @param pageable
	 * @return
	 */
	// @Override
	// public List<Product> findByCid(int cid, Pageable pageable) {
	// //查找出所有二级分类
	// List<Classification> sec = classificationDao.findByParentId(cid);
	// List<Integer> secIds = new ArrayList<>();
	// for (Classification classification : sec) {
	// secIds.add(classification.getId());
	// }
	// return productDao.findByCsidIn(secIds,pageable);
	// }

	/**
	 * 根据二级分类查找商品
	 *
	 * @return
	 */
	// @Override
	// public List<Product> findByCsid(int csid, Pageable pageable) {
	// return productDao.findByCsid(csid,pageable);
	// }

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
//		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		return productMapper.selectAll();
	}


}
