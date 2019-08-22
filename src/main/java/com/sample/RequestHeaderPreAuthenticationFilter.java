package com.sample;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class RequestHeaderPreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		return createAppUserFromHeaders(request);
	}
	
	private Object createAppUserFromHeaders(HttpServletRequest request) {
		String username = request.getHeader("USER_NAME");
		String groups = request.getHeader("USER_GROUPS");
		Collection<GrantedAuthority> authorities = null;
		
		if (groups != null) {
			authorities = extractAuthorities(groups);	
		}
		
		return new AppUser(username, authorities);
	}

	private Collection<GrantedAuthority> extractAuthorities(String groups) {
		List<String> authorities = Arrays.asList(groups.split("\\s*,\\s*"));
		
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return "Not Applicable"; // Credentials are not required
	}

}
