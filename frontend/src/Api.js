import axios from "axios";

const SERVER_URL = "http://localhost:8080/api/";

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000,
  headers: { "X-Requested-With": "application/json" }
});

export default {
  getAll: () => instance.get(""),

  getByCode: code => instance.get(code)
};
