package Interceptor.Middleware2.Interceptors;

import Interceptor.Middleware2.Entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public List<Month> theMonths = List.of(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "Marsch"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Kann"),
            new Month(6, "June", "Giugno", "Juni")
    );

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (httpServletRequest.getRequestURI().contains("/months")) {
            String monthNumber = httpServletRequest.getHeader("monthNumber");
            if (monthNumber != null) {
                int intNumber = Integer.parseInt(monthNumber);
                Optional<Month> monthFound = theMonths.stream()
                        .filter(singleMonth -> singleMonth.getMonthNumber() == intNumber)
                        .findFirst();
                if (monthFound.isPresent()) {
                    httpServletRequest.setAttribute("MonthInterceptor-month", monthFound.get());
                } else {
                    httpServletRequest.setAttribute("MonthInterceptor-month",
                            new Month(0, "nope", "nope", "nope"));
                }
                httpServletResponse.setStatus(200);
                return true;
            } else {
                httpServletResponse.setStatus(400);
                return false;
            }
        }
        return true;
    }
}
