package io.didasoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MesssageController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PathMatchingResourcePatternResolver resourcePatternResolver;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/msg")
    public String getMessage(@RequestParam String code, @RequestParam String locale) {
        Locale ll = new Locale(locale);
        return messageSource.getMessage(code, null, ll);
    }
}
