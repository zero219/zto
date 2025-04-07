package com.zto.common.results;

public class Code {
    // 请求成功。一般用于 GET 与 POST 请求。
    public static final Integer OK = 200;
    // 已创建。成功请求并创建了新的资源。
    public static final Integer Created = 201;
    // 已接受。已经接受请求，但未处理完成。
    public static final Integer Accepted = 202;
    // 无内容
    public static final Integer NoContent = 204;
    // 未修改
    public static final Integer NotModified = 304;
    //  客户端请求的语法错误，服务器无法理解。
    public static final Integer BadRequest = 400;
    // 401：Unauthorized 请求要求用户的身份认证。
    public static final Integer Unauthorized = 401;
    // 403：Forbidden 服务器理解请求客户端的请求，但是拒绝执行此请求。
    public static final Integer Forbidden = 403;
    // 404：Not Found 服务器无法根据客户端的请求找到资源（网页）。
    public static final Integer NotFound = 404;
    // 500：Internal Server Error 服务器内部错误，无法完成请求。
    public static final Integer InternalServerError = 500;
}
