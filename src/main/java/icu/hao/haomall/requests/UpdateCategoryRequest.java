package icu.hao.haomall.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateCategoryRequest {


    @NotNull(message = "id cannot be empty")
    private Integer id;
    @NotNull
    @Size(min = 2, max = 5)
    private String name;
    @NotNull
    @Max(3)
    private Integer type;
    @NotNull
    private Integer parentId;

    private Integer orderNum;

    public String getName() {
        return name;
    }
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
