package mk.ukim.finki.application.service;

import mk.ukim.finki.application.model.requests.AbstractRequest;
import mk.ukim.finki.application.model.requests.RequestDecorator;


import java.util.List;
import java.util.Optional;

public interface RequestService {
    Optional<AbstractRequest> createRequest(AbstractRequest request);

    List<AbstractRequest> listAll();

    Optional<RequestDecorator> findById(Long requestId);

    List<AbstractRequest> listAllDecorator();

    void deleteById(Long id);
}
