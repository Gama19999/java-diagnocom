package ovh.serial30.diagnocom.configuration;

import org.springframework.http.HttpStatus;
import ovh.serial30.diagnocom.exceptions.TokenException;
import ovh.serial30.diagnocom.services.JWTService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.List;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;
    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (isPublicRoute(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            var token = request.getHeader(Const.Headers.TOKEN);
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            var userId = jwtService.getUserId(token);
            if (jwtService.isValidToken(token) && authentication == null) {
                var authToken = new UsernamePasswordAuthenticationToken(userId, null, List.of());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response);
        } catch (IllegalArgumentException iae) { // protected endpoint request without token
            logger.error(iae.getMessage());
            handlerExceptionResolver.resolveException(request, response, null, new TokenException(HttpStatus.FORBIDDEN.value(), Const.Logs.ACCESS_DENIED));
        } catch (JwtException jwte) {
            logger.error(jwte.getMessage());
            handlerExceptionResolver.resolveException(request, response, null, new TokenException(HttpStatus.UNAUTHORIZED.value(), Const.Logs.INVALID_TOKEN));
        } catch (Exception e) {
            logger.error(e.getMessage());
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }

    private boolean isPublicRoute(HttpServletRequest request) {
        return request.getHeader(Const.Headers.TOKEN) == null &&
               (request.getRequestURI().contains(Const.Routes.AUTH) ||
                request.getRequestURI().contains(Const.Routes.HOME));
    }
}
