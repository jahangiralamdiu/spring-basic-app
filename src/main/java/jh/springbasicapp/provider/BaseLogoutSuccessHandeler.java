package jh.springbasicapp.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by BS-113-Jahangir on 3/6/2015.
 */
public class BaseLogoutSuccessHandeler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String redirectUrl = "/logout";
        if (authentication != null)
            request.getSession().invalidate();
        response.sendRedirect(redirectUrl);

        super.onLogoutSuccess(request, response, authentication);
    }
}
