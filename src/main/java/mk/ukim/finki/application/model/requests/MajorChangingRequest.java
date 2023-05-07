package mk.ukim.finki.application.model.requests;


import lombok.Data;
import mk.ukim.finki.application.model.enums.MajorType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class MajorChangingRequest extends RequestDecorator{

    @Enumerated(EnumType.STRING)
    private MajorType currentMajorType;
    @Enumerated(EnumType.STRING)
    private MajorType newMajorType;

    public MajorChangingRequest(BaseRequest request, MajorType currentMajorType, MajorType newMajorType) {
        super(request);
        this.currentMajorType = currentMajorType;
        this.newMajorType = newMajorType;
    }

    public MajorChangingRequest() {

    }
}
