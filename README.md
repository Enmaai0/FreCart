# _Global Exception Handler_ / _全局异常处理器_

In the `GlobalExceptionHandler` class, I added a new `@ExceptionHandler` method to handle the `MethodArgumentNotValidException` exception. This method uses the `@ResponseBody` annotation to return a response body containing error messages, making it easier for clients to retrieve exception details. The implementation uses the `BindingResult` interface to get validation error messages and returns them to the client.

在 `GlobalExceptionHandler` 类中，我添加了一个新的 `@ExceptionHandler` 方法，用于处理 `MethodArgumentNotValidException` 类的异常。该方法使用 `@ResponseBody` 注解，以便返回一个包含错误信息的响应主体，方便客户端获取异常信息。具体实现中，使用 `BindingResult` 接口来获取验证错误信息，并将这些信息返回给客户端。

## Example Code / 示例代码
```java
@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        return handleBindingResult(e.getBindingResult());
    }

    private ApiRestResponse handleBindingResult(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                messages.add(defaultMessage);
            }
        }
        if (messages.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.Request_Param_Error);
        }
        return ApiRestResponse.error(ExceptionEnum.Request_Param_Error.getCode(), messages.toString());
    }
