package mk.ukim.finki.application.model.requests;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RequestDecorator extends AbstractRequest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    private BaseRequest baseRequest;

    public RequestDecorator(BaseRequest request) {
        this.baseRequest = request;
    }

    public RequestDecorator() {

    }
}
