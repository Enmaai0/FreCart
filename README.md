# Feature: Add Category Functionality / 特性：添加类别功能

## Overview / 概述

In this feature branch, I implemented the functionality to add a new category in the `CategoryController`. This functionality requires admin privileges, ensuring that only authorized users can create new categories.

在这个特性分支中，我在 `CategoryController` 中实现了添加新类别的功能。该功能需要管理权限，以确保只有授权用户才能创建新类别。
## Key Implementation Details / 关键实现细节

1. **Admin Privileges / 管理权限**:
   - The `addCategory` method checks whether the current user has admin privileges before allowing them to add a new category. If the user does not have the necessary permissions, an error response is returned.

2. **Request Parameter Validation / 请求参数验证**:
   - To ensure data integrity and security, we created a dedicated class `AddCategoryRequest` to encapsulate the parameters required for adding a category. This class helps in validating the input data and prevents the inclusion of unnecessary or potentially harmful parameters.

3. **AddCategoryRequest Class / AddCategoryRequest 类**:
   - This class contains the following fields:
     - `name`: The name of the category.
     - `type`: The type of the category.
     - `parentId`: The ID of the parent category.
     - `orderNum`: The order number for sorting categories.

   ```java
   public class AddCategoryRequest {
       private String name;
       private Integer type;
       private Integer parentId;
       private Integer orderNum;

       // Getters and Setters
   }
   
   Code Implementation / 代码实现
Here is the implementation of the addCategory method in the CategoryController:
