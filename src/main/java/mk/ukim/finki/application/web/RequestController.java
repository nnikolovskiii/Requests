package mk.ukim.finki.application.web;

import mk.ukim.finki.application.model.dto.RequestDto;
import mk.ukim.finki.application.model.requests.AbstractRequest;
import mk.ukim.finki.application.model.requests.RequestDecorator;
import mk.ukim.finki.application.model.requests.RequestFactory;
import mk.ukim.finki.application.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestFactory requestFactory;
    private final RequestService service;

    public RequestController(RequestFactory factory, RequestService service) {
        this.requestFactory = factory;
        this.service = service;
    }


    @GetMapping
    private List<AbstractRequest> findAll() {
        return this.service.listAllDecorator();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDecorator> findById(@PathVariable Long id) {
        return this.service.findById(id)
                .map(request -> ResponseEntity.ok().body(request))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<AbstractRequest> save(@RequestBody RequestDto requestDto) {
        AbstractRequest request= requestFactory.createRequestFromDto(null,requestDto);
        return this.service.createRequest(request)
                .map(req -> ResponseEntity.ok().body(req))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<AbstractRequest> save(@PathVariable Long id, @RequestBody  RequestDto requestDto) {
        AbstractRequest request= requestFactory.createRequestFromDto(id,requestDto);
        return this.service.createRequest(request)
                .map(req -> ResponseEntity.ok().body(req))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.service.deleteById(id);
        if (this.service.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
