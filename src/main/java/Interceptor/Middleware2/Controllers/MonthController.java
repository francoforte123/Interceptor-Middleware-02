package Interceptor.Middleware2.Controllers;

import Interceptor.Middleware2.Entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonth(HttpServletRequest httpServletRequest) {
        return (Month) httpServletRequest.getAttribute("MonthInterceptor-month");
    }
}
