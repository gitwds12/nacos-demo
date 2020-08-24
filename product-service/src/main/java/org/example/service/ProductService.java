package org.example.service;

import org.example.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询商品列表
     *
     * @return
     */
    List<Product> selectProductList();
}
