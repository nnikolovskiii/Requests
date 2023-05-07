package mk.ukim.finki.application.model.requests;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PaymentRequest extends RequestDecorator{

    private Integer numOfInstallments;

    public PaymentRequest(BaseRequest request, Integer numOfInstallments) {
        super(request);
        this.numOfInstallments = numOfInstallments;
    }

    public PaymentRequest() {

    }
}
