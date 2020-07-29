import axios from "axios";

const SERVER_URL = "http://localhost:8080/api/";

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000
});

export default {
  // getAll: (url, config) =>
  //   instance.get('', {
  //     transformResponse: [
  //       function(data) {
  //         return data ? JSON.parse(data)._embedded.todos : data
  //       },
  //     ],
  //   }),
  getAll: () => instance.get(""),

  getByCode: code => instance.get(code)
};
