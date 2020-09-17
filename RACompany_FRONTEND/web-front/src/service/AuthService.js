import axios from "axios";

const url = "http://localhost:8080/RACompany/rest/";

export default {
  login(credentials) {
    return axios
      .post(url + "login", credentials, {
          headers : {
            'Access-Control-Allow-Origin':'http://localhost:8081/login, http://localhost:8081' ,
            'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
            'Access-Control-Allow-Credentials' : true,

          }
      })
      .then((response) => response.data);
  },
  signUp(credentials) {
    return axios
      .post(url + "register", credentials)
      .then((response) => response.data);
  },
  logout(credentials) {
    return axios.post(url + "logout", credentials);
  },
};
