package jh.springbasicapp.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by BS-113-Jahangir on 3/6/2015.
 */
public class BaseAuthenticationSuccessHandeler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String redirectUrl = "/";

        if(auth != null)

            response.sendRedirect(redirectUrl);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}

