package net.imwork.zhanlong.commons;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * 小小工具
 * @author zhanlong
 *
 */
public class CommonUtils {
	/**
	 * 返回一个不重复的字符串
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 把map转换成对象
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 把Map转换成指定类型
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T mapToBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 通过参数clazz创建实例
			 * 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *	Java正确获取客户端真实IP方法整理
	 *
	 * 		在JSP里，获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
	 * 但是在通过了Apache，Squid等反向代理软件就不能获取到客户端的真实IP地址了。
	 * 如果使用了反向代理软件，将http://192.168.1.110:2046/的URL反向代理为http://www.abc.com/的URL时，
	 * 用request.getRemoteAddr()方法获取的IP地址是：127.0.0.1或192.168.1.110，而并不是客户端的真实IP。
	 * 经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的IP，
	 * 服务器端应用也无法直接通过转发请求的地址返回给客户端。
	 * 但是在转发请求的HTTP头信息中，增加了X-FORWARDED-FOR信息。用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
	 * 当我们访问http://www.abc.com/index.jsp/时，其实并不是我们浏览器真正访问到了服务器上的index.jsp文件，
	 * 而是先由代理服务器去访问http://192.168.1.110：2046/index.jsp，代理服务器再将访问到的结果返回给我们的浏览器，
	 * 因为是代理服务器去访问index.jsp的，所以index.jsp中通过request.getRemoteAddr()的方法获取的IP实际上是代理服务器的地址，
	 * 并不是客户端的IP地址。
	 *
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
