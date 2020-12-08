package org.example.controller;

import org.example.pojo.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${coupon.name:}")
    private String productName;

    @Value("${project.name:}")
    private String projectName;

    @Value("${project.org:}")
    private String projectOrg;

    @Value("${jdbc.name:}")
    private String jdbcName;

    @Value("${ext.name:}")
    private String extName;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> configMap = new HashMap();
        configMap.put("productName", productName);
        configMap.put("projectName", projectName);
        configMap.put("projectOrg", projectOrg);
        configMap.put("jdbcName", jdbcName);
        configMap.put("extName", extName);
        return configMap;
    }

    /**
     * 查询商品列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<Product> selectProductList() {
        return productService.selectProductList();
    }
}
