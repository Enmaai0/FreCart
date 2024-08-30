package icu.hao.haomall.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddProductRequest {
    @NotNull(message = "Product name cannot be null")
    private String name;
    @NotNull(message = "Product image cannot be null")
    private String image;
    private String detail;
    @NotNull(message = "Product category cannot be null")
    private Integer categoryId;
    @NotNull(message = "Product price cannot be null")
    @Min(value = 1, message = "Product price must be greater than 1 cent")
    private Integer price;
    @NotNull(message = "Product stock cannot be null")
    @Max(value = 10000, message = "Product stock must be less than 10000")
    private Integer stock;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
