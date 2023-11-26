package co.com.system.invoice.configuration;

import co.com.system.invoice.model.SellingPoint;
import co.com.system.invoice.model.User;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import co.com.system.invoice.service.user.GetUserService;
import co.com.system.invoice.utils.SecurityUtils;
import co.com.system.invoice.utils.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TokenInformation implements TokenEnhancer {

    private final  GetUserService getUserService;
    private final GetSellingPointService getSellingPointService;



    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        String userName = SecurityUtils.getUserName(oAuth2Authentication.getName());
        Integer company = SecurityUtils.getSellingPoint(oAuth2Authentication.getName());
        Optional<User> user = getUserService.findByUserName(userName);

        Optional<SellingPoint> sellingPoint = getSellingPointService.findById(company);


        Map<String, Object> info = new HashMap<>();
        info.put("userId", user.get().getId());
        info.put("sellingPointName", sellingPoint.isPresent() ? sellingPoint.get().getName(): StringUtils.empty);
        info.put("sellingPointId", company);

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
