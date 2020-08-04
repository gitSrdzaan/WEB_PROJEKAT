import axios from "axios";

const url = "http://localhost:8080/RACompany/rest/";

export default {
  login(credentials) {
    return axios
      .post(url + "login", credentials)
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
