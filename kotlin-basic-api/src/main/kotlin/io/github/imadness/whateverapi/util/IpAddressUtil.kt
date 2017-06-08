import javax.servlet.http.HttpServletRequest

/**
 * Позволяет определять IP-адрес клиента на основе HTTP-заголовков его запроса
 */
object IpAddressUtil {
    private val HEADERS_TO_TRY = arrayOf("X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR")

    /**
     * Перебирает HTTP-заголовки и проверяет каждый из них на наличие "unknown", если нет - возвращает значение данного заголовка.
     * В противном случае возвращает IP-адрес с помощью "стандартного" метода `HttpServletRequest`

     * @param request
     * @return строка, содержащая IP-адрес клиента
     */
    fun getClientIpAddress(request: HttpServletRequest): String {
        for (header in HEADERS_TO_TRY) {
            val ip = request.getHeader(header)
            if (ip != null && ip.length != 0 && !"unknown".equals(ip, ignoreCase = true))
                return ip
        }
        return request.remoteAddr
    }
}