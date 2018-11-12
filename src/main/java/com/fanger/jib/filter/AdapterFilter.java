package com.fanger.jib.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 作用：
 *    1. 在HttpServletRequest到达Servlet之前，拦截客户的HttpServletRequest。
 *    2. 根据需要检查HttpServletRequest，也可以修改HttpServletRequest头和数据。
 *    3. 在HttpServletResponse到达客户端之前，拦截HttpServletResponse。
 *    4. 根据需要检查HttpServletResponse，也可以修改HttpServletResponse头和数据。
 *
 * @author Xiaofanger
 * @create 2018/11/12 0012
 */
@Slf4j
public class AdapterFilter implements Filter {

    /**
     * filter的init方法在容器初始化时加载。
     * 第一次加载容器执行顺序随机，以后再次加载顺序以第一次加载顺序为准。
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化AdapterFilter");
    }

    /**
     * filter的 doFilter() 方法在请求url时执行，
     * doFilter方法里面最后要调用FilterChain的doFilter方法，
     * 这个方法作用是继续执行下个filter,如果没有加，则不执行下面的filter。
     *
     * chain.doFilter()，执行该方法之前，即对用户请求进行预处理；执行该方法之后，即对服务器响应进行后处理。
     *
     * 该方法在执行完servlet之后再次调用此方法，与请求时调用的方向相仿。
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("执行AdapterFilter之前");
        chain.doFilter(request, response);
        log.info("执行AdapterFilter之后");
    }

    /***
     * 服务器停止后销毁，晚于Servlet销毁之后
     */
    @Override
    public void destroy() {
        log.info("注销AdapterFilter");
    }
}
