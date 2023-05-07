package mk.ukim.finki.application.model.requests;

import mk.ukim.finki.application.model.Application;
import mk.ukim.finki.application.model.dto.*;
import mk.ukim.finki.application.model.enums.ApplicationType;
import mk.ukim.finki.application.model.enums.MajorType;
import mk.ukim.finki.application.model.enums.RequestStatus;
import mk.ukim.finki.application.service.ApplicationService;
import mk.ukim.finki.application.service.CourseService;
import mk.ukim.finki.application.service.ProfessorService;
import mk.ukim.finki.application.service.RequestService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class RequestFactory {
    private final RequestService requestService;
    private final ApplicationService applicationService;

    private final ProfessorService professorService;

    private final CourseService courseService;
    public RequestFactory(RequestService requestService,
                          ApplicationService applicationService, ProfessorService professorService, CourseService courseService) {
        this.requestService = requestService;
        this.applicationService = applicationService;
        this.professorService = professorService;
        this.courseService = courseService;
    }

    public AbstractRequest createRequest(Long applicationId,
                                     String description,
                                     Long courseId,
                                     Long currentProfessorId,
                                     Long newProfessorId,
                                     Integer numOfInstallments,
                                     MajorType currentMajorType,
                                     MajorType newMajorType) {
        Application application = applicationService.findById(applicationId);
        BaseRequest baseRequest = new BaseRequest(application, description,
                RequestStatus.PENDING, LocalDate.now());

        AbstractRequest request = null;
        ApplicationType applicationType = application.getApplicationType();
        if (applicationType==ApplicationType.CREDITS_35_PLUS){
            request = new CreditsRequest(baseRequest,
                    professorService.findById(currentProfessorId),
                    courseService.findById(courseId));
        }else if (applicationType == ApplicationType.MAJOR_CHANGING){
            request = new MajorChangingRequest(baseRequest,
                    currentMajorType, newMajorType);
        }else if (applicationType == ApplicationType.PAYMENT_INSTALLMENTS){
            request = new PaymentRequest(baseRequest,
                    numOfInstallments);
        }else if (applicationType == ApplicationType.COURSE_WITHOUT_PREREQUISITE){
            request = new NoPrerequisitesRequest(baseRequest,
                    professorService.findById(currentProfessorId),
                    courseService.findById(courseId));
        }else if (applicationType == ApplicationType.PROFESSOR_CHANGING){
            request = new ChangeProfessorRequest(baseRequest,
                    courseService.findById(courseId),
                    professorService.findById(currentProfessorId),
                    professorService.findById(newProfessorId));
        }

        return request;
    }


    public AbstractRequest createRequestFromDto(Long id, RequestDto requestDto) {
        Long applicationId = requestDto.getApplication();
        Application application = applicationService.findById(applicationId);
        BaseRequest baseRequest = new BaseRequest(application,
                requestDto.getDescription(),
                RequestStatus.PENDING, LocalDate.now());
        if (id!=null){
            RequestDecorator request = requestService.findById(id).get();
            baseRequest.setId(request.getBaseRequest().getId());
        }

        ApplicationType applicationType = application.getApplicationType();

        AbstractRequest request = null;
        if (applicationType==ApplicationType.CREDITS_35_PLUS){
            request = new CreditsRequest(baseRequest,
                    professorService.findById(requestDto.getCurrentProfessor()),
                    courseService.findById(requestDto.getCourse()));
        }else if (applicationType == ApplicationType.MAJOR_CHANGING){
            request = new MajorChangingRequest(baseRequest,
                    MajorType.valueOf(requestDto.getCurrentMajorType()),
                    MajorType.valueOf(requestDto.getNewMajorType()));
        }else if (applicationType == ApplicationType.PAYMENT_INSTALLMENTS){
            request = new PaymentRequest(baseRequest,
                    requestDto.getNumOfInstallments());
        }else if (applicationType == ApplicationType.COURSE_WITHOUT_PREREQUISITE){
            request = new NoPrerequisitesRequest(baseRequest,
                    professorService.findById(requestDto.getCurrentProfessor()),
                    courseService.findById(requestDto.getCourse()));
        }else if (applicationType == ApplicationType.PROFESSOR_CHANGING){
            request = new ChangeProfessorRequest(baseRequest,
                    courseService.findById(requestDto.getCourse()),
                    professorService.findById(requestDto.getCurrentProfessor()),
                    professorService.findById(requestDto.getNewProfessor()));
        }

        if (id!=null){
            request.setId(id);
        }


        return request;
    }

}
