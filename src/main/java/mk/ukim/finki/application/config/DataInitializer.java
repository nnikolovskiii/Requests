package mk.ukim.finki.application.config;

import mk.ukim.finki.application.Application;
import mk.ukim.finki.application.model.requests.*;
import mk.ukim.finki.application.service.RequestService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final RequestService service;

    public DataInitializer(RequestService service) {
        this.service = service;
    }


    @PostConstruct
    public void fillDB(){
        AbstractRequest request;
        BaseRequest baseRequest = new BaseRequest();
        PaymentRequest r = new PaymentRequest(
                baseRequest, 10
        );


        request = r;
        service.createRequest(request);


    }
}
