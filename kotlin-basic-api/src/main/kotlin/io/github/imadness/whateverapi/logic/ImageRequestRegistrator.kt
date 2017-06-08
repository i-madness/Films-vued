package io.github.imadness.whateverapi.logic

import IpAddressUtil
import io.github.imadness.whateverapi.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Контроллер для перехвата запросов на картинку, встраиваемую куда-либо.
 * Предназначен для подсчёта посетителей на конкретной странице.
 */
@Controller
class ImageRequestRegistrator {
    @Autowired
    lateinit var servletContext: ServletContext

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @ResponseBody
    @GetMapping(value = "/img")
    fun processRequest(req: HttpServletRequest, resp: HttpServletResponse): ResponseEntity<InputStreamResource> {
        val inpstream = ClassPathResource("invis_img.png").inputStream
        var ipAddress = IpAddressUtil.getClientIpAddress(req)
        customerRepository.save(Customer(ipAddress, System.currentTimeMillis().toString()))
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(InputStreamResource(inpstream))
    }
}