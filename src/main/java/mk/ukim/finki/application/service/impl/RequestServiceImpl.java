package mk.ukim.finki.application.service.impl;

import mk.ukim.finki.application.model.requests.AbstractRequest;
import mk.ukim.finki.application.model.requests.RequestDecorator;
import mk.ukim.finki.application.repository.jpa.RequestDecoratorRepository;
import mk.ukim.finki.application.repository.jpa.RequestRepository;
import mk.ukim.finki.application.service.RequestService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RequestServiceImpl implements RequestService {
    private final RequestRepository repository;
    private final RequestDecoratorRepository decoratorRepository;

    public RequestServiceImpl(RequestRepository repository, RequestDecoratorRepository decoratorRepository) {
        this.repository = repository;
        this.decoratorRepository = decoratorRepository;
    }

    @Override
    public Optional<AbstractRequest> createRequest(AbstractRequest request) {
        return Optional.of(repository.save(request));

    }

    @Override
    public List<AbstractRequest> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RequestDecorator> findById(Long requestId) {
        return decoratorRepository.findById(requestId);
    }

    @Override
    public List<AbstractRequest> listAllDecorator() {
        return decoratorRepository.findAll().stream().map(r->(AbstractRequest)r).toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
