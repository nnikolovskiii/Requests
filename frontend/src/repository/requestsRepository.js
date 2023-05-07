import axios from '../custom-axios/axios';

const RequestService = {
    fetchRequests: () => {
        return axios.get("/requests");
    },
    fetchApplications: () => {
        return axios.get("/applications");
    },
    fetchMajors: () => {
        return axios.get("/majors");
    },
    fetchApplicationTypes: () => {
        return axios.get("/applicationTypes");
    },
    fetchRequestStatus: () => {
        return axios.get("/requestStatus");
    },
    fetchCourses: () => {
        return axios.get("/courses");
    },
    fetchProfessors: () => {
        return axios.get("/professors");
    },
    deleteRequest: (id) => {
        return axios.delete(`/requests/delete/${id}`);
    },
    addRequest: (application, description,
                 requestStatus, submissionDate,
                 course=-1, currentProfessor=-1,
                 newProfessor=-1, currentMajorType="",
                 newMajorType="", numOfInstallments=0) => {
        return axios.post("/requests/add", {
            "application": application,
            "description": description,
            "requestStatus": requestStatus,
            "submissionDate": submissionDate,
            "course": course,
            "currentProfessor": currentProfessor,
            "newProfessor": newProfessor,
            "currentMajorType": currentMajorType,
            "newMajorType": newMajorType,
            "numOfInstallments": numOfInstallments
        });
    },
    editRequest: (id, application, description,
                  requestStatus, submissionDate,
                  course=-1, currentProfessor=-1,
                  newProfessor=-1, currentMajorType="",
                  newMajorType="", numOfInstallments=0) => {
        return axios.put(`/requests/edit/${id}`, {
            "application": application,
            "description": description,
            "requestStatus": requestStatus,
            "submissionDate": submissionDate,
            "course": course,
            "currentProfessor": currentProfessor,
            "newProfessor": newProfessor,
            "currentMajorType": currentMajorType,
            "newMajorType": newMajorType,
            "numOfInstallments": numOfInstallments
        });
    },
    getRequest: (id) => {
        return axios.get(`/requests/${id}`);
    },
    login: (username, password) => {
        return axios.post("/login", {
            "username": username,
            "password": password
        });
    },
}

export default RequestService;

